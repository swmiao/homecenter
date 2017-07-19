package com.rm.homecenter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "CATALOG" )
public class Catalog {
	
	private long id;
	private String guid;
	private String catalogName;
	private String fileExtention;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public String getFileExtention() {
		return fileExtention;
	}
	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}	

}
