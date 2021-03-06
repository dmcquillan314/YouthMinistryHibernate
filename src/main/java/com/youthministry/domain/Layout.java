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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQueries({
	@NamedQuery(
		name = "Layout.findAll",
		query = "from LAYOUT"
	)
})
@Entity(name="LAYOUT")
@Table(name="LAYOUT")
public class Layout {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LAYOUT_ID")
	private Long layoutId;
	
	@Column(name="LAYOUT_NAME")
	private String layoutName;
	
	@Column(name="LAYOUT_DESCRIPTION")
	@Lob
	private String layoutDescription;
	
	@OneToMany (targetEntity = Row.class, cascade =  CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Collection<Row> rows = new ArrayList<Row>();

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}

	public String getLayoutDescription() {
		return layoutDescription;
	}

	public void setLayoutDescription(String layoutDescription) {
		this.layoutDescription = layoutDescription;
	}

	public Collection<Row> getRows() {
		return rows;
	}

	public void setRows(Collection<Row> rows) {
		this.rows = rows;
	}

}
