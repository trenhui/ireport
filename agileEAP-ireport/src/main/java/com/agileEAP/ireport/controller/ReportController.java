package com.agileEAP.ireport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import com.agileEAP.util.JsonConvert;

/**
 * @author trenhui
 * 
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

	@RequestMapping(method = RequestMethod.GET)
	public String report() {
		//JsonConvert jsonConvert = new JsonConvert();
		//jsonConvert.Serial(null);
		
		return "report/display";
	}

	@RequestMapping(value = "/designer", method = RequestMethod.GET)
	public String designer() {
		return "report/designer";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "report/index";
	}
}
