package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObject;
import com.cgi.tools.eaconnector.bo.EaObjectConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectConstraintRepository extends JpaRepository<EaObjectConstraint, Integer> {
}
