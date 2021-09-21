package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaDiagram;
import com.cgi.tools.eaconnector.bo.EaDiagramObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EaDiagramObjectRepository extends JpaRepository<EaDiagramObject, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "delete t_diagramobjects where diagram_id=:diagramId", nativeQuery = true)
    int deleteByDiagramId(@Param("diagramId") Integer diagramId);

    List<EaDiagramObject> findByEaObject_Id(int id);


}
