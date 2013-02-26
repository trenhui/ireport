package com.agileEAP.ireport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author trenhui
 * 
 */
@Controller
@RequestMapping(value = "/DBConn")
public class DBConnController {

	@RequestMapping(method = RequestMethod.GET)
	public String display() {
		//JsonConvert jsonConvert = new JsonConvert();
		//jsonConvert.Serial(null);
		
		return "DBConn/display";
	}
}
