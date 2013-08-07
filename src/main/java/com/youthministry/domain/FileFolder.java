package com.youthministry.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class FileFolder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FILE_FOLDER_ID")
	private Long id;
	
	@Column(name="FILE_FOLDER_NAME")
	private String fileFolderName;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "FILE_FOLDER_FILES",
	joinColumns = @JoinColumn(name = "FILE_FOLDER_ID"),
	inverseJoinColumns = @JoinColumn(name = "FILE_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private List<File> files;
	
	@Column(name="PARENT_FOLDER_ID")
	private Long parentFolderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileFolderName() {
		return fileFolderName;
	}

	public void setFileFolderName(String fileFolderName) {
		this.fileFolderName = fileFolderName;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Long getParentFolderId() {
		return parentFolderId;
	}

	public void setParentFolderId(Long parentFolderId) {
		this.parentFolderId = parentFolderId;
	}
	
}
