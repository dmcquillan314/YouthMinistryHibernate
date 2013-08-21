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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="COL")
@Table(name="COL")
public class Col {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COL_ID")
	private Long columnId;
	
	@Column(name="COL_WIDTH")
	private String columnWidth;

	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "COL_PAGE_CONTENT",
		joinColumns = @JoinColumn(name = "COL_ID"),
		inverseJoinColumns = @JoinColumn(name = "PAGE_CONTENT_ID"))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	@Fetch(FetchMode.SELECT)
	private Collection<PageContent> contentItems = new ArrayList<PageContent>();

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

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	/**
	 * @return the columnWidth
	 */
	public String getColumnWidth() {
		return columnWidth;
	}

	/**
	 * @param columnWidth the columnWidth to set
	 */
	public void setColumnWidth(String columnWidth) {
		this.columnWidth = columnWidth;
	}

}
