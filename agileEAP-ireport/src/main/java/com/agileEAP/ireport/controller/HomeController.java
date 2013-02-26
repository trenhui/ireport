package com.agileEAP.ireport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.agileEAP.ireport.repository.ReportCatalogRepository;
import com.agileEAP.ireport.repository.ReportRepository;
import com.agileEAP.ireport.repository.UserRepository;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
/*	private ReportCatalogRepository reportCatalogRepository;
	private ReportRepository reportRepository;
	private UserRepository userRepository;*/
	
	@RequestMapping(method = RequestMethod.GET)
	public String report() {
		return "home/index";
	}
	
/*	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	public void setReportRepository(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	
	@Autowired
	public void setReportCatalogRepository(ReportCatalogRepository reportCatalogRepository) {
		this.reportCatalogRepository = reportCatalogRepository;
	}*/
}
