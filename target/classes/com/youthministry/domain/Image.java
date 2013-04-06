package com.youthministry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Image extends PageContent {
	@Column(name="PATH_TO_IMAGE")
	private String pathToImage;
	@Column(name="ALT_TEXT")
	private String altText;
	@Column(name="TITLE_TEXT")
	private String titleText;
	
	public String getPathToImage() {
		return pathToImage;
	}
	public void setPathToImage(String pathToImage) {
		this.pathToImage = pathToImage;
	}
	public String getAltText() {
		return altText;
	}
	public void setAltText(String altText) {
		this.altText = altText;
	}
	public String getTitleText() {
		return titleText;
	}
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}
	
}