package com.youthministry.domain;

import java.util.Collection;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="PAGE")
@Table(name="PAGE")
public class Page {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAGE_ID")
	private Long pageId;
	
	@Column(name="PAGE_NAME")
	private String pageName;
	
	@Column(name="PAGE_URL")
	private String pageUrl;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "PAGE_PAGE_CONTENT",
		joinColumns = @JoinColumn(name = "PAGE_ID"),
		inverseJoinColumns = @JoinColumn(name = "PAGE_CONTENT_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<PageContent> contentItems = new ArrayList<PageContent>();

	// TODO: PARENT PAGES, META TAGS

	/**
	 * @return the pageId
	 */
	public Long getPageId() {
		return pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(Long pageId) {
		this.pageId = pageId;
	}

	/**
	 * @return the pageName
	 */
	public String getPageName() {
		return pageName;
	}

	/**
	 * @param pageName the pageName to set
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	/**
	 * @return the pageURL
	 */
	public String getPageUrl() {
		return pageUrl;
	}

	/**
	 * @param pageURL the pageURL to set
	 */
	public void setPageURL(String pageURL) {
		this.pageUrl = pageURL;
	}

	/**
	 * @return the contentItems
	 */
	public Collection<PageContent> getContentItems() {
		return contentItems;
	}

	/**
	 * @param contentItems the contentItems to set
	 */
	public void setContentItems(Collection<PageContent> contentItems) {
		this.contentItems = contentItems;
	}

}
