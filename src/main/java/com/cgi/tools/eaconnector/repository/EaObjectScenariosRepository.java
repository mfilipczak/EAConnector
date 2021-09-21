package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectRequires;
import com.cgi.tools.eaconnector.bo.EaObjectScenarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectScenariosRepository extends JpaRepository<EaObjectScenarios, Integer> {
}
