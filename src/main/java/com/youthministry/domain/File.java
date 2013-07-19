package com.youthministry.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
		name = "File.findAll",
		query = "from FILE"
	)
})
@Entity(name="FILE")
@Table(name="FILE")
public class File {
	@Id
	@GeneratedValue
	@Column(name="FILE_ID")
	private Long id;

	@Column(name="FILE_NAME")
	private String name;

	@Column(name="FILE_DESCRIPTION")
	private String description;

	@Column(name="ORIGINAL_FILE_NAME")
	private String fileName;

	@Column(name="FILE_DATA", nullable=false)
	@Lob
	private byte[] fileData;
	
	@Column(name="FILE_SIZE")
	private Long fileSize;
	
	@Column(name="CONTENT_TYPE")
	private String contentType;
	
	@Column(name="CREATED")
	private Date created;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getFileName() {
		return fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public Date getCreated() {
		return created;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
}
