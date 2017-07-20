package com.rm.homecenter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;

@Entity
@Table(name="FILEATTRIBUTE")
public class FileAttribute {
	
	private String id;
	private String guid;
	private String fileName;
	private String filePath;
	private String fileExtention;
	private String fileSize;
	private String parentName;

	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
