package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@OneToMany (targetEntity = Row.class, cascade =  CascadeType.ALL)
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
