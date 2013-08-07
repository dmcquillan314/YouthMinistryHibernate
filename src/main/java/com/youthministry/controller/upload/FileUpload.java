package com.youthministry.controller.upload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {
	
	private String fileName;
	private String fileDescription;
	private CommonsMultipartFile fileData;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

}
