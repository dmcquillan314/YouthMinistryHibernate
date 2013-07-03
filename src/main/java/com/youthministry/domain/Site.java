package com.youthministry.domain;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="SITE")
@Table(name="SITE")
public class Site {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SITE_ID")
	private Long siteId;
	
	@Column(name="SITE_NAME")
	private String siteName;
	
	// TODO: private Map<String, String> siteVars;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PAGE_ID")
	private Page homePage = new Page();

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Page getHomePage() {
		return homePage;
	}

	public void setHomePage(Page homePage) {
		this.homePage = homePage;
	}

}
