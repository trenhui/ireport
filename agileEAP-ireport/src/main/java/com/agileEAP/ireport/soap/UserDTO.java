package com.agileEAP.ireport.soap;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ToStringBuilder;

@XmlRootElement(name = "User")
public class UserDTO {
	private Long id;
	private String loginName;
	private String name;
	private String plainPassword;
	private String password;
	private String salt;
	private String roles;
	private Date registerDate;


	public Long getId() {
		return id;
	}

	public void setId(Long value) {
		id = value;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String value) {
		loginName = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}


	/**
	 * 重新实现toString()函数方便在日志中打印DTO信息.
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
