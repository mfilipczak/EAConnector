package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObject;
import com.cgi.tools.eaconnector.bo.EaPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EaObjectRepository extends JpaRepository<EaObject, Integer> {
    List<EaObject> findByName(String name);

    @Query(value = "SELECT object_id, name from t_object where object_id = :id", nativeQuery = true)
    List<Object[]> getByIdSimple(@Param("id") int id);

    @Query(value = "SELECT TOP 1 object_id, name from t_object where object_id = (select classifier from t_object where object_id =:id)", nativeQuery = true)
    List<Object[]> getClassifierById(@Param("id") int id);

    @Query(value = "SELECT object_id, name from t_object where classifier =:id", nativeQuery = true)
    List<Object[]> getByClassifier(@Param("id") int id);

}
