package com.youthministry.domain;

import java.util.Collection;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQueries({
	@NamedQuery(
			name = "Page.findAll",
			query = "from PAGE"
	),
	@NamedQuery(
			name = "Page.findByUrl",
			query = "from PAGE where pageUrl = :pageUrl"
	)
})
@Entity(name="PAGE")
@Table(name="PAGE")
public class Page {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAGE_ID")
	private Long pageId;
	
	@Column(name="PAGE_NAME")
	private String pageName;
	
	@Column(name="PAGE_URL", unique=true)
	private String pageUrl;
	
	@Column(name="PAGE_TITLE")
	private String pageTitle;
	
	@Column(name="CONTENT_TYPE")
	private String contentType;
	
	@Column(name="PAGE_DESCRIPTION")
	@Lob
	private String pageDescription;
	
	@Column(name="PAGE_KEYWORDS")
	@Lob
	private String pageKeywords;
	
	@OneToMany (targetEntity = Row.class, cascade =  CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	private Collection<Row> rows = new ArrayList<Row>();
	
	@Column(name="PARENT_PAGE_ID")
	private Long parentPageId;
	
	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	public String getPageKeywords() {
		return pageKeywords;
	}

	public void setPageKeywords(String pageKeywords) {
		this.pageKeywords = pageKeywords;
	}

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
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public Long getParentPageId() {
		return parentPageId;
	}

	public void setParentPageId(Long parentPageId) {
		this.parentPageId = parentPageId;
	}

	/**
	 * @return the rows
	 */
	public Collection<Row> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Collection<Row> rows) {
		this.rows = rows;
	}

}
