package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaConnectorConstraint;
import com.cgi.tools.eaconnector.bo.EaObjectConstraint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaConnectorConstraintRepository extends JpaRepository<EaConnectorConstraint, Integer> {
}
