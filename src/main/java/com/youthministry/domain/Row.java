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
public class Row {
	
	@Column(name="ROW_ID")
	private Long rowId;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "ROW_COL",
		joinColumns = @JoinColumn(name = "ROW_ID"),
		inverseJoinColumns = @JoinColumn(name = "COL_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<Col> cols = new ArrayList<Col>();

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Collection<Col> getCols() {
		return cols;
	}

	public void setCols(Collection<Col> cols) {
		this.cols = cols;
	}

}
