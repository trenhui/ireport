package com.agileEAP.ireport.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "SearchUserResult", namespace = WsConstants.NS)
public class SearchUserResult extends WSResult {

	private List<UserDTO> userList;

	public SearchUserResult() {
	}

	public SearchUserResult(List<UserDTO> userList) {
		this.userList = userList;
	}

	@XmlElementWrapper(name = "userList")
	@XmlElement(name = "user")
	public List<UserDTO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDTO> userList) {
		this.userList = userList;
	}
}
