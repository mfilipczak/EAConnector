package com.cgi.tools.eaconnector.service;

import com.cgi.tools.eaconnector.repository.EaConnectorRepository;
import com.cgi.tools.eaconnector.repository.EaDiagramRepository;
import com.cgi.tools.eaconnector.repository.EaObjectRepository;
import com.cgi.tools.eaconnector.repository.EaPackageRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//@ShellComponent
public class EaRelationsService {

    private static Logger LOG = LoggerFactory.getLogger(EaRelationsService.class);

    private final EaPackageRepository eaPackageRepository;
    private final EaObjectRepository eaObjectRepository;
    private final EaDiagramRepository eaDiagramRepository;
    private final EaConnectorRepository eaConnectorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private final Map<Integer, String> CLASSIFIERS = new HashMap<>();
    private final Map<Integer, String> DIAGRAMS = new HashMap<>();

   // @ShellMethod("Sprawdzanie zależności, format check-dependencies nazwa_pakietu")
    public void checkDependencies(@NotNull String packageName) {
        LOG.info("Rozpoczynanie sprawdzania zaleznosci dla pakietu {}", packageName);
        List<Object[]> packageList = eaPackageRepository.findByName(packageName);
        Set<Integer> packagesToDelete = new HashSet<>();
        Set<Integer> diagramsToDelete = new HashSet<>();
        Set<Integer> objectsToDelete = new HashSet<>();
        Set<Integer> connectorsToDelete = new HashSet<>();
        Map<Integer, Set<Integer>> diagramLinks = new HashMap<>();
        packageList.forEach(o -> processPackage(Integer.parseInt(""+o[0]), packagesToDelete, diagramsToDelete, objectsToDelete, connectorsToDelete, diagramLinks));
        diagramLinks.forEach((key, value) -> value.removeAll(diagramsToDelete));
        connectorsToDelete.addAll(diagramLinks.entrySet().stream().filter(dls-> dls.getValue().isEmpty()).map(Map.Entry::getKey).collect(Collectors.toList()));
        checkConnectorIsUsed(connectorsToDelete, diagramsToDelete);
        checkObjectIsUsedAsClassifier(objectsToDelete);
        checkObjectIsUsedAsStartOrEnd(objectsToDelete, connectorsToDelete);
    }


    private void checkConnectorIsUsed(Set<Integer> connectorsToDelete, Set<Integer> diagramsToDelete) {
        List<Integer> obToDel = new ArrayList<>(connectorsToDelete);
        int i=0;
        while(i<obToDel.size()){
            int nextInc = Math.min(obToDel.size()-i,1000);
            checkConnectorIsUsedBatch(obToDel.subList(i,i+nextInc), diagramsToDelete);
            i = i + nextInc;
        }
    }
    @SuppressWarnings("unchecked")
    private void checkConnectorIsUsedBatch(List<Integer> connectorsToDeleteBatch, Set<Integer> diagramsToDelete) {
        final List<Integer> diagramIds = entityManager.createNativeQuery("SELECT diagramid from t_connector where connector_id in (:ids) and diagramId <> 0")
                .setParameter("ids", connectorsToDeleteBatch).getResultList();
        List<Integer> dl = diagramIds.stream().filter(integer -> !diagramsToDelete.contains(integer)).collect(Collectors.toList());
        if(!dl.isEmpty()) {
            LOG.error("Znaleziono zaleznosc dla diagramu {}", dl);
        }
    }

    private void checkObjectIsUsedAsClassifier(Set<Integer> objectsToDelete) {
        List<Integer> obToDel = new ArrayList<>(objectsToDelete);
        int i=0;
        while(i<obToDel.size()){
            int nextInc = Math.min(obToDel.size()-i,1000);
            checkObjectIsUsedAsClassifierBatch(objectsToDelete, obToDel.subList(i,i+nextInc));
            i = i + nextInc;
        }
    }

    @SuppressWarnings("unchecked")
    private void checkObjectIsUsedAsClassifierBatch(Set<Integer> objectsToDelete, List<Integer> batch) {
        final List<Integer> objectIds = entityManager.createNativeQuery("SELECT object_id from t_object where classifier_guid in (select ea_guid from t_object where object_id in (:ids))")
                .setParameter("ids", batch).getResultList();
        List<Integer> dl = objectIds.stream().filter(integer -> !objectsToDelete.contains(integer)).collect(Collectors.toList());
        if(!dl.isEmpty()) {
            LOG.error("Znaleziono zaleznosci:\n{}", dl.stream().map(this::getClassifier).distinct().collect(Collectors.joining("\n")));
        }
    }

    public String getClassifier(Integer id) {
        return CLASSIFIERS.computeIfAbsent(id, key-> {
            List<Object[]> objects = eaObjectRepository.getByIdSimple(id);
            Object[] classifier = eaObjectRepository.getClassifierById(id).get(0);
            return String.format("Classsifer %s dla obiektow [%s]",
                    classifier[1] + "(" +classifier[0] +")",
                    objects.stream()
                            .map(d -> "Id " + d[0] +
                                    "; nazwa " + d[1])
                            .collect(Collectors.joining(";")));
        });
    }

    private void checkObjectIsUsedAsStartOrEnd(Set<Integer> objectsToDelete, Set<Integer> connectorsToDelete) {
        List<Integer> obToDel = new ArrayList<>(objectsToDelete);
        int i=0;
        Set<Integer> checked = new HashSet<>();
        while(i<obToDel.size()){
            int nextInc = Math.min(obToDel.size()-i,1000);
            checkObjectIsUsedAsStartOrEndBatch(connectorsToDelete, obToDel.subList(i,i+nextInc), checked);
            i = i + nextInc;
        }
    }

    @SuppressWarnings("unchecked")
    private void checkObjectIsUsedAsStartOrEndBatch(Set<Integer> connectorsToDelete, List<Integer> batch, Set<Integer> checked) {
        final List<Integer> objectIds = entityManager.createNativeQuery("SELECT connector_id from t_connector where Start_Object_ID in (:ids) or End_Object_ID in (:ids)")
                .setParameter("ids", batch).getResultList();
        List<Integer> dl = objectIds.stream().filter(integer -> !connectorsToDelete.contains(integer) && !checked.contains(integer)).collect(Collectors.toList());
        checked.addAll(dl);
        if(!dl.isEmpty()) {
            String info = dl.stream().map(this::getDiagrams).filter(s->!s.isBlank()).collect(Collectors.joining("\n"));
            if(!info.isBlank()) {
                LOG.error("Znaleziono zaleznosci: \n{}", info);
            }
        }
    }

    private String getDiagrams(Integer id) {
        return DIAGRAMS.computeIfAbsent(id, key-> {
            Object[] current = eaConnectorRepository.getStartAndEnd(id).get(0);
            List<Object[]> diagrams = eaDiagramRepository.findByConnectors_Id(id);
            diagrams.addAll(eaDiagramRepository.findByDiagramLinks_EaConnector_Id(id));
            Optional<Object[]> start = eaObjectRepository.getByIdSimple(Integer.parseInt(""+current[0])).stream().findFirst();
            Optional<Object[]> end = eaObjectRepository.getByIdSimple(Integer.parseInt(""+current[1])).stream().findFirst();
            if(diagrams.isEmpty()) {
                return "";
            }else {
                return String.format("Obiekty [Start - %s] [End - %s] powiazane z diagramami [%s]", start.map(o -> o[0] + ";" + o[1]).orElse("NULL"), end.map(o -> o[0] + ";" + o[1]).orElse("NULL"), diagrams.stream().map(d -> "Id " + d[0] + "; nazwa " + d[1]).collect(Collectors.joining(";")));
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void processPackage(int packageId, Set<Integer> packagesToDelete, Set<Integer> diagramsToDelete, Set<Integer> objectsToDelete, Set<Integer> connectorsToDelete, Map<Integer, Set<Integer>> diagramLinks) {
        packagesToDelete.add(packageId);
        List<Integer> l = (List<Integer>)entityManager.createNativeQuery("SELECT package_id from t_package where parent_id = ?")
                .setParameter(1, packageId).getResultList();
        l.forEach(id ->processPackage(id, packagesToDelete, diagramsToDelete, objectsToDelete, connectorsToDelete, diagramLinks));
        objectsToDelete.addAll(entityManager.createNativeQuery("SELECT object_id from t_object where package_id = ?")
                .setParameter(1, packageId).getResultList());
        final List<Integer> diagramIds = entityManager.createNativeQuery("SELECT diagram_id from t_diagram where package_id = ?")
                .setParameter(1, packageId).getResultList();


        if(!diagramIds.isEmpty()) {
            Query q = entityManager.createNativeQuery("SELECT dl1.diagramId, dl1.connectorId FROM t_diagramlinks dl1 WHERE dl1.diagramId in (:ids)");
            List<Object[]> cIds = q.setParameter("ids", diagramIds).getResultList();
            cIds.forEach(dls -> diagramLinks.computeIfAbsent(Integer.parseInt("" +dls[1]), key -> new HashSet<>()).add(Integer.parseInt("" +dls[0])));
            connectorsToDelete.addAll(entityManager.createNativeQuery("select connector_id from t_connector where DiagramId in (:ids)")
                    .setParameter("ids", diagramIds).getResultList());

            diagramsToDelete.addAll(diagramIds);
        }
    }

}
