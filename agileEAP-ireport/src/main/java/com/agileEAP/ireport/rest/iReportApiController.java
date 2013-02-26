package com.agileEAP.ireport.rest;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agileEAP.ireport.service.*;
import com.agileEAP.ireport.repository.ReportCatalogRepository;
import com.agileEAP.ireport.repository.ReportRepository;
import com.agileEAP.ireport.repository.UserRepository;
import com.agileEAP.ireport.entity.*;
import com.agileEAP.ireport.viewModel.*;

@Controller
@RequestMapping(value = "/api/v1/report/")
public class iReportApiController {
	@Autowired
	private ReportService reportService;

	@Autowired
	private AccountService accountService;

	/*
	 * @Autowired private ReportCatalogRepository reportCatalogRepository;
	 */

	@RequestMapping(value = "/reportTree.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TreeNodeModel> ireportTree() {
		List<TreeNodeModel> nodelist = new Vector<TreeNodeModel>();
		TreeNodeModel treeNode = new TreeNodeModel();
		treeNode.setId("0");
		treeNode.setData("我的报表");
		// treeNode.setAttr("");
		nodelist.add(treeNode);

/*		treeNode = new TreeNodeModel();
		treeNode.setId("mydatasource");
		treeNode.setData("数据源");
		// treeNode.setAttr("");
		nodelist.add(treeNode);*/

		List<ReportCatalog> reportCatalogs = reportService.getAllCatalog();
		buildReportTree(treeNode, reportCatalogs);

/*		for (ReportCatalog catalog : reportCatalogs) {
			if (catalog.getParentID() == 0) {
				TreeNodeModel node = new TreeNodeModel();
				node.setId(catalog.getId().toString());
				node.setData(catalog.getName());
				// node.attr={};
				nodelist.add(node);
			}
		}*/

		/*
		 * for (ReportCatalog catalog : reportCatalogs) { if
		 * (catalog.getParentID() == 0) { TreeNodeModel node = new
		 * TreeNodeModel(); node.setId(catalog.getId().toString());
		 * node.setData(catalog.getName()); // node.attr={}; nodelist.add(node);
		 * } }
		 */

		return nodelist;
	}

	private TreeNodeModel buildReportTree(TreeNodeModel parentNode,
			List<ReportCatalog> reportCatalogs) {
		if (parentNode.getChildren() == null)
			parentNode.setChildren(new Vector<TreeNodeModel>());

		for (ReportCatalog catalog : reportCatalogs) {
			if (catalog.getParentID() == Long.parseLong(parentNode.getId())) {
				TreeNodeModel node = new TreeNodeModel();
				node.setId(catalog.getId().toString());
				node.setData(catalog.getName());
				// node.attr={};
				parentNode.getChildren().add(node);
				
				List<ReportMetadata> reportMetaDatas=reportService.findReportMetaDataByCatalogID(catalog.getId());
				
				for(ReportMetadata report :reportMetaDatas)
				{
					TreeNodeModel childNode = new TreeNodeModel();
					childNode.setId(report.getId().toString());
					childNode.setData(report.getName());
					// node.attr={};
					node.getChildren().add(childNode);
				}
				
				buildReportTree(node,reportCatalogs);
			}
		}
		return parentNode;
	}

	@RequestMapping(value = "/catalog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TreeNodeModel> catalog() {
		List<TreeNodeModel> nodelist = new Vector<TreeNodeModel>();
		List<ReportCatalog> reportCatalogs = reportService.getAllCatalog();

		for (ReportCatalog catalog : reportCatalogs) {
			TreeNodeModel node = new TreeNodeModel();
			node.setId(catalog.getId().toString());
			node.setData(catalog.getName());
			// node.attr={};
			nodelist.add(node);
		}

		return nodelist;
	}

	/*
	 * @RequestMapping(value = "/metadata", method = RequestMethod.GET, produces
	 * = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody public List<ReportMetaData> metadata() {
	 * 
	 * List<ReportMetaData> reportCatalogs =
	 * reportService.getAllReportMetaData();
	 * 
	 * return reportCatalogs; }
	 * 
	 * @RequestMapping(value = "/account", method = RequestMethod.GET, produces
	 * = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody public List<User> account() {
	 * 
	 * List<User> reportCatalogs = accountService.getAllUser();
	 * 
	 * return reportCatalogs; }
	 */
}
