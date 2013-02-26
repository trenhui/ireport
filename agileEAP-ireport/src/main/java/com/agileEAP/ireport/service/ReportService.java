package com.agileEAP.ireport.service;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.agileEAP.ireport.entity.*;
import com.agileEAP.ireport.repository.ReportCatalogRepository;
import com.agileEAP.ireport.repository.ReportRepository;
import com.agileEAP.ireport.repository.UserRepository;

@Component
@Transactional(readOnly = true)
public class ReportService {
	private ReportCatalogRepository reportCatalogRepository;
	private ReportRepository reportRepository;
	private UserRepository userRepository;

	public List<ReportCatalog> getAllCatalog() {

		List<ReportCatalog> reportCatalogs =(List<ReportCatalog>) reportCatalogRepository.findAll();

		return reportCatalogs;
	}

	public List<ReportMetadata> getAllReportMetaData() {

		List<ReportMetadata> reportCatalogs = reportRepository.findAll();

		return reportCatalogs;
	}
	
	public List<ReportMetadata> getReportCatalog() {

		List<ReportMetadata> reportCatalogs = reportRepository.findAll();

		return reportCatalogs;
	}
	
	public List<ReportMetadata> findReportMetaDataByCatalogID(Long catalogID) {

		List<ReportMetadata> reportCatalogs =reportRepository.findByCatalogID(catalogID);

		return reportCatalogs;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setReportRepository(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}

	@Autowired
	public void setReportCatalogRepository(
			ReportCatalogRepository reportCatalogRepository) {
		this.reportCatalogRepository = reportCatalogRepository;
	}

}
