package com.youthministry.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class TextEntry extends PageContent {
	
	private String contentTitle;
	@Lob
	private String contentBody;
	
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