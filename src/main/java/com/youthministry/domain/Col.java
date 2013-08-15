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
	
	@Column(name="COL_WIDTH")
	private String columnWidth;

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	/**
	 * @return the columnWidth
	 */
	public String getColumnWidth() {
		return columnWidth;
	}

	/**
	 * @param columnWidth the columnWidth to set
	 */
	public void setColumnWidth(String columnWidth) {
		this.columnWidth = columnWidth;
	}

}
