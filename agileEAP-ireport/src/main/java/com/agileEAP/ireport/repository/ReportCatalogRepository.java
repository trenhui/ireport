package com.agileEAP.ireport.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agileEAP.ireport.entity.ReportCatalog;

public interface ReportCatalogRepository  extends JpaRepository<ReportCatalog, Long> {
	//ReportCatalog findByTheName(String Name);
	
/*	@Query("select c from ReportCatalog c")
	List<ReportCatalog> findAll();*/
}
