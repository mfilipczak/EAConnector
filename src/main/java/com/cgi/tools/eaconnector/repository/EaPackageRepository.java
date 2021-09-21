package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EaPackageRepository extends JpaRepository<EaPackage, Integer> {

    @Query(value = "select * from T_PACKAGE where parent_id = 0", nativeQuery = true)
    List<EaPackage> findAllWithoutRoot();
    @Query(value = "select package_id from T_PACKAGE where parent_id = 0 and name = :name", nativeQuery = true)
    List<Object[]> findByName(@Param("name") String name);

}
