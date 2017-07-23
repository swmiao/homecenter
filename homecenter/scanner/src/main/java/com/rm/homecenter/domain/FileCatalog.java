package com.rm.homecenter.domain;

import javax.persistence.*;

@Entity
@Table( name = "CATALOG" )
public class FileCatalog {
	
	private long id;
	private String guid;
	private String catalogName;
	private String fileExtention;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")
	@TableGenerator(name = "customer_gen",
			table="tb_id_generator",
			pkColumnName="gen_name",
			valueColumnName="gen_value",
			pkColumnValue="FILE_Catalog_ID",
			allocationSize=1
	)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@Column
	public String getFileExtention() {
		return fileExtention;
	}
	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}	

}
