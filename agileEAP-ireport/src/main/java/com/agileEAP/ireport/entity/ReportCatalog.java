package com.agileEAP.ireport.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ab_reportcatalog")
public class ReportCatalog extends BaseEntity<Long> {
	private String name;
	private Long parentID;
	private String ctrlData;
	private Date createTime;
	private String creator;

	public ReportCatalog() {
	}

	public ReportCatalog(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCtrlData() {
		return ctrlData;
	}

	public void setCtrlData(String ctrlData) {
		this.ctrlData = ctrlData;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
