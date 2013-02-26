package com.agileEAP.ireport.viewModel;

import java.util.List;
import java.util.Vector;

public class TreeNodeModel {
	private List<TreeNodeModel> children;
	private String id;
	private Object attr;
	private Object data;
	private String state;
	
	public TreeNodeModel()
	{
		children=new Vector<TreeNodeModel>();
	}
	
	public List<TreeNodeModel> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNodeModel> children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getAttr() {
		return attr;
	}
	public void setAttr(Object attr) {
		this.attr = attr;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
