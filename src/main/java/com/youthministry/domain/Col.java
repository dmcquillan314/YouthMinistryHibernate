package com.youthministry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="COL")
@Table(name="COL")
public class Col {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COL_ID")
	private Long columnId;
	
	@Column(name="COL_NAME")
	private String columnName;
	
	@Column(name="COL_DESC")
	private String columnDesc;

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnDesc() {
		return columnDesc;
	}

	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}

}
