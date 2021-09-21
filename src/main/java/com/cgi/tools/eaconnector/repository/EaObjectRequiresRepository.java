package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectProperties;
import com.cgi.tools.eaconnector.bo.EaObjectRequires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectRequiresRepository extends JpaRepository<EaObjectRequires, Integer> {
}
