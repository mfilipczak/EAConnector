package com.cgi.tools.eaconnector.service;

import com.cgi.tools.eaconnector.bo.EaPackage;
import com.cgi.tools.eaconnector.repository.EaPackageRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
//@ShellComponent
public class EaPackageService {

    private static Logger LOG = LoggerFactory.getLogger(EaPackageService.class);

    private final EaPackageRepository eaPackageRepository;
    @PersistenceContext
    private EntityManager entityManager;

   // @ShellMethod("Usuwanie pakietu, format delete-package nazwa_pakietu")
    @Transactional(rollbackFor = Exception.class)
    public void deletePackage(@NotNull String name) {
        LOG.info("Rozpoczynanie usuwania pakietu {}", name);
        List<Object[]> packageList = eaPackageRepository.findByName(name);
        packageList.forEach(o -> processDeletePackage(Integer.parseInt(""+o[0])));
    }



    @SuppressWarnings("unchecked")
    private void processDeletePackage(int id) {
        List<Integer> l = (List<Integer>)entityManager.createNativeQuery("SELECT package_id from t_package where parent_id = ?")
                .setParameter(1, id).getResultList();
        l.forEach(this::processDeletePackage);
        final List<Integer> obIds = entityManager.createNativeQuery("SELECT object_id from t_object where package_id = ?")
                .setParameter(1, id).getResultList();
        Stream.of("t_objectconstraint",
                "t_objecteffort",
                "t_objectfiles",
                "t_objectmetrics",
                "t_objectproblems",
                "t_objectrequires",
                "t_objectscenarios",
                "t_objectproperties").forEach(t -> removeObjectParts(obIds, t));
        if(!obIds.isEmpty()) {
            Query q = entityManager.createNativeQuery("DELETE FROM t_xref WHERE client IN (SELECT ea_guid FROM t_object WHERE object_id IN (:ids))");
            q.setParameter("ids", obIds);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_object WHERE object_id IN (:ids)");
            q.setParameter("ids", obIds);
            q.executeUpdate();
        }

        final List<Integer> diagramIds = entityManager.createNativeQuery("SELECT diagram_id from t_diagram where package_id = ?")
                .setParameter(1, id).getResultList();
        if(!diagramIds.isEmpty()) {
            removeDiagramObjects(diagramIds);
            removeConnectors(diagramIds);
            removeDiagramLinks(diagramIds);
            Query q = entityManager.createNativeQuery("DELETE FROM t_xref WHERE client IN (SELECT ea_guid FROM t_diagram WHERE diagram_id IN (:ids))");
            q.setParameter("ids", diagramIds);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_diagram WHERE diagram_id IN (:ids)");
            q.setParameter("ids", diagramIds);
            q.executeUpdate();
        }
        Query q = entityManager.createNativeQuery("DELETE FROM t_xref WHERE client IN (SELECT ea_guid FROM t_package WHERE package_id = ?)");
        q.setParameter(1, id);
        q.executeUpdate();
        q = entityManager.createNativeQuery("DELETE FROM t_package WHERE package_id = ?");
        q.setParameter(1, id);
        q.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    private void removeDiagramLinks(List<Integer> diagramId) {
        if(!diagramId.isEmpty()) {
            Query q = entityManager.createNativeQuery("SELECT dl1.connectorId FROM t_diagramlinks dl1 JOIN t_diagramlinks dl2 ON dl1.connectorid = dl2.connectorid WHERE dl1.diagramId in (:ids) GROUP BY dl1.connectorid HAVING count(dl1.diagramId) = 1");
            List<Integer> cIds = q.setParameter("ids", diagramId).getResultList();
            q = entityManager.createNativeQuery("DELETE FROM t_diagramlinks WHERE diagramId in (:ids)");
            q.setParameter("ids", diagramId);
            q.executeUpdate();
            removeConnectorsByIds(cIds);
        }
    }

    private void removeDiagramObjects(List<Integer> diagramId) {
        if(!diagramId.isEmpty()) {
            Query q = entityManager.createNativeQuery("DELETE FROM t_diagramobjects WHERE diagram_Id in (:ids)");
            q.setParameter("ids", diagramId);
            q.executeUpdate();
        }
    }

    private void removeConnectorsByIds(List<Integer> cIds) {
        if(!cIds.isEmpty()) {
            Query q = entityManager.createNativeQuery("DELETE FROM t_connectorconstraint WHERE connectorid IN (:ids)");
            q.setParameter("ids", cIds);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_xref WHERE client IN (SELECT ea_guid FROM t_connector WHERE connector_id IN (:ids))");
            q.setParameter("ids", cIds);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_connector WHERE connector_id in (:ids)");
            q.setParameter("ids", cIds);
            q.executeUpdate();
        }
    }
    private void removeConnectors(List<Integer> diagramId) {
        if(!diagramId.isEmpty()) {
            Query q = entityManager.createNativeQuery("DELETE FROM t_connectorconstraint WHERE connectorid IN (select connector_id from t_connector where DiagramId in (:ids))");
            q.setParameter("ids", diagramId);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_xref WHERE client IN (SELECT ea_guid FROM t_connector WHERE diagramId IN (:ids))");
            q.setParameter("ids", diagramId);
            q.executeUpdate();
            q = entityManager.createNativeQuery("DELETE FROM t_connector WHERE diagramId in (:ids)");
            q.setParameter("ids", diagramId);
            q.executeUpdate();
        }
    }

    private void removeObjectParts(List<Integer> obIds, String table){
        Query q = entityManager.createNativeQuery("DELETE FROM "+table +" WHERE object_id IN (:ids)");
        q.setParameter("ids", obIds);
        q.executeUpdate();
    }
}
