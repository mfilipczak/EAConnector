package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaDiagram;
import com.cgi.tools.eaconnector.bo.EaPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EaDiagramRepository extends JpaRepository<EaDiagram, Integer> {

    @Query(value = "SELECT d.diagram_id, d.name from t_diagram d, t_diagramlinks do where do.diagramId = d.diagram_id and do.connectorid = :id ", nativeQuery = true)
    List<Object[]> findByDiagramLinks_EaConnector_Id(@Param("id") int id);

    @Query(value = "SELECT d.diagram_id, d.name from t_diagram d, t_diagramobjects do where do.diagram_Id = d.diagram_id and do.object_id = :id ", nativeQuery = true)
    List<Object[]> findByDiagramObjects_EaObject_Id(@Param("id") int id);

    @Query(value = "SELECT d.diagram_id, d.name from t_diagram d, t_connector c where c.diagramId = d.diagram_id and connector_id = :id ", nativeQuery = true)
    List<Object[]> findByConnectors_Id(@Param("id") int id);



}
