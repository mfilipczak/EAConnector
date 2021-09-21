package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaObjectFiles;
import com.cgi.tools.eaconnector.bo.EaObjectMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaObjectMetricsRepository extends JpaRepository<EaObjectMetrics, Integer> {
}
