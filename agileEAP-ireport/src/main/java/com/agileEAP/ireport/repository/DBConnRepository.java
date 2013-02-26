package com.agileEAP.ireport.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.agileEAP.ireport.entity.DBConn;

public interface DBConnRepository  extends PagingAndSortingRepository<DBConn, Long> {
	
	DBConn findByName(String Name);
	
	List<DBConn> findAll();
}