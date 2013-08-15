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


@Table(name="PAGE_COL")
@Entity(name="PAGE_COL")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class PageCol extends Col {

	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "COL_PAGE_CONTENT",
		joinColumns = @JoinColumn(name = "COL_ID"),
		inverseJoinColumns = @JoinColumn(name = "PAGE_CONTENT_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<PageContent> contentItems = new ArrayList<PageContent>();

}
