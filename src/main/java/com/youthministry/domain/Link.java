package com.youthministry.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
		name = "Link.findByName",
		query = "from Link l where l.linkName = :name"
	),
	@NamedQuery(
		name = "Link.findAll",
		query = "from Link"
	)
})
@Entity
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

	public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkClass() {
		return linkClass;
	}

	public void setLinkClass(String linkClass) {
		this.linkClass = linkClass;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}

}
