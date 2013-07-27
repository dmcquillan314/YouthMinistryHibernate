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

@Entity(name="ROW")
@Table(name="ROW")
public class Row {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROW_ID")
	private Long rowId;

	@Column(name="ROW_TAG_NAME")
	private String tagName;
	
	@OneToMany (targetEntity = Col.class, cascade =  CascadeType.ALL)
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
