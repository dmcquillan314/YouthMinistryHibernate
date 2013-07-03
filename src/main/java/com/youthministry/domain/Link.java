package com.youthministry.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="LINK")
@Table(name="LINK")
public class Link {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LINK_ID")	
	private Long linkId;
	
	@Column(name="LINK_NAME")
	private String linkName;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "LINK_PAGE",
		joinColumns = @JoinColumn(name = "LINK_ID"),
		inverseJoinColumns = @JoinColumn(name = "PAGE_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Page page = new Page();
	
	@Column(name="LINK_URL")
	private String linkUrl;
	
	@Column(name="LINK_CLASS")
	private String linkClass;
	
	@Column(name="LINK_TARGET")
	private String linkTarget;

}
