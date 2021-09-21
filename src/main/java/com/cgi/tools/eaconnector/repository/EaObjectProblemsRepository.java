package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectMetrics;
import com.cgi.tools.eaconnector.bo.EaObjectProblems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectProblemsRepository extends JpaRepository<EaObjectProblems, Integer> {
}
