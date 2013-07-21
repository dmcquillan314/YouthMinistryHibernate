package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="COLUMN")
@Table(name="COLUMN")
public class Col {

	@Column(name="COL_ID")
	private Long columnId;
	
	@Column(name="COL_NAME")
	private String columnName;
	
	@Column(name="COL_DESC")
	private String columnDesc;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "COL_ROW",
		joinColumns = @JoinColumn(name = "COL_ID"),
		inverseJoinColumns = @JoinColumn(name = "ROW_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<Row> rows = new ArrayList<Row>();

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

	public Collection<Row> getRows() {
		return rows;
	}

	public void setRows(Collection<Row> rows) {
		this.rows = rows;
	}

}
