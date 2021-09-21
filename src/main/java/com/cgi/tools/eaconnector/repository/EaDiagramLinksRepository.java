package com.cgi.tools.eaconnector.repository;

import com.cgi.tools.eaconnector.bo.EaDiagramLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EaDiagramLinksRepository extends JpaRepository<EaDiagramLinks, Integer> {

}
