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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@NamedQueries(
	@NamedQuery(
		name = "PageContent.findAll",
		query = "from PAGE_CONTENT"
	)
)
@Entity(name="PAGE_CONTENT")
@Table(name="PAGE_CONTENT")
@Inheritance (strategy=InheritanceType.JOINED)
public class PageContent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PAGE_CONTENT_ID")	
	private Long pageContentId;
	@Column(name="PAGE_CONTENT_NAME", nullable=false)
	private String pageContentName;
		
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "IMAGE_PAGE_CONTENT",
	joinColumns = @JoinColumn(name = "PAGE_CONTENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "IMAGE_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<Image> images = new ArrayList<Image>();
	
	@Column(name="CONTENT_TITLE")
	private String contentTitle;
	@Lob
	@Column(name="CONTENT_BODY")
	private String contentBody;
	
	public Long getPageContentId() {
		return pageContentId;
	}
	public void setPageContentId(Long pageContentId) {
		this.pageContentId = pageContentId;
	}
	public String getPageContentName() {
		return pageContentName;
	}
	public void setPageContentName(String pageContentName) {
		this.pageContentName = pageContentName;
	}
	public Collection<Image> getImages() {
		return images;
	}
	public void setImages(Collection<Image> images) {
		this.images = images;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getContentBody() {
		return contentBody;
	}
	public void setContentBody(String contentBody) {
		this.contentBody = contentBody;
	}
	
}