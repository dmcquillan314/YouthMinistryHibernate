package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Table(name="PAGE_ROW")
@Entity(name="PAGE_ROW")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PageRow extends Row {
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "PROW_PCOL",
		joinColumns = @JoinColumn(name = "ROW_ID"),
		inverseJoinColumns = @JoinColumn(name = "COL_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<PageCol> pageCols = new ArrayList<PageCol>();

	/**
	 * @return the pageCols
	 */
	public Collection<PageCol> getPageCols() {
		return pageCols;
	}

	/**
	 * @param pageCols the pageCols to set
	 */
	public void setPageCols(Collection<PageCol> pageCols) {
		this.pageCols = pageCols;
	}

}
