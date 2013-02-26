package com.agileEAP.ireport.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agileEAP.ireport.entity.ReportMetadata;

public interface ReportRepository  extends JpaRepository<ReportMetadata, Long> {
	
	//ReportMetadata findByName(String name);
	
	//@Query("select c from ReportMetadata c where c.catalogID=?1")
	List<ReportMetadata> findByCatalogID(Long catalogID);
}
