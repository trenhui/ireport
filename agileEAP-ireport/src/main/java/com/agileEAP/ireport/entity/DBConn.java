package com.agileEAP.ireport.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ab_dbconn")
public class DBConn extends BaseEntity<Long> {
	private String name;
	private String dbtype;
	private String connString;
	private String ctrlData;
	private Date createTime;
	private String creator;

	public DBConn() {
	}

	public DBConn(Long id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDBtype() {
		return dbtype;
	}

	public void setDBtype(String dbtype) {
		this.dbtype = dbtype;
	}

	public String getConnString() {
		return connString;
	}

	public void setConnString(String connString) {
		this.connString = connString;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	// 璁惧畾JSON搴忓垪鍖栨椂鐨勬棩鏈熸牸寮�
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getCtrlData() {
		return ctrlData;
	}

	public void setCtrlData(String ctrlData) {
		this.ctrlData = ctrlData;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
