package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectProblems;
import com.cgi.tools.eaconnector.bo.EaObjectProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectPropertiesRepository extends JpaRepository<EaObjectProperties, Integer> {
}
