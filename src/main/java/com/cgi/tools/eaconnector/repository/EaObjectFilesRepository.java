package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectConstraint;
import com.cgi.tools.eaconnector.bo.EaObjectFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectFilesRepository extends JpaRepository<EaObjectFiles, Integer> {
}
