package com.youthministry.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="LINK")
@Table(name="LINK")
public class Link {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LINK_ID")	
	private Long linkId;
	
	@Column(name="LINK_NAME")
	private String linkName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PAGE_ID")
	private Page page = new Page();
	
	@Column(name="LINK_URL")
	private String linkUrl;
	
	@Column(name="LINK_CLASS")
	private String linkClass;
	
	@Column(name="LINK_TARGET")
	private String linkTarget;

}
