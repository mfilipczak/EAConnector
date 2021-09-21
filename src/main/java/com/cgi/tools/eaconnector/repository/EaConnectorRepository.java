package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaConnector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EaConnectorRepository extends JpaRepository<EaConnector, Integer> {

    @Query(value = "SELECT start_object_id, end_object_id from t_connector where connector_id = :id", nativeQuery = true)
    List<Object[]> getStartAndEnd(@Param("id") int id);
}
