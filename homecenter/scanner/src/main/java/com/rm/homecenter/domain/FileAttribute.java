package com.rm.homecenter.domain;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.text.DecimalFormat;

@Entity
@Table(name="FILEATTRIBUTE")
@NamedQueries({
		@NamedQuery(name="findByfileName",query="SELECT f FROM FileAttribute f where f.fileName= ?1")
	})
public class FileAttribute {
	
	private long id;
	private String guid;
	private String fileName;
	private String filePath;
	private String fileExtention;
	private String fileSize;
	private String parentName;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE,generator="customer_gen")
	@TableGenerator(name = "customer_gen",
			table="tb_id_generator",
			pkColumnName="gen_name",
			valueColumnName="gen_value",
			pkColumnValue="FILE_ATTR_ID",
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column
	public String getFileExtention() {
		return fileExtention;
	}
	public void setFileExtention(String fileExtention) {
		this.fileExtention = fileExtention;
	}

	@Column
	public String getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileSize(long fileSize) {
		double sizeTemp = fileSize;
		DecimalFormat df = new DecimalFormat("0.00");
		if(sizeTemp / 1024 > 1) {
			sizeTemp = sizeTemp / 1024;
			if(sizeTemp / 1024 > 1) {
				sizeTemp = sizeTemp / 1024;
				if(sizeTemp / 1024 > 1) {
					sizeTemp = sizeTemp / 1024;
					setFileSize(df.format(sizeTemp) + " G");
				}else{
					setFileSize(df.format(sizeTemp) + " M");
				}
			} else{
				setFileSize(df.format(sizeTemp) + " K");
			}
		}else{
			setFileSize(df.format(sizeTemp));
		}
		
	}

	@Column
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
