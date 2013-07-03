package com.youthministry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity(name="TEMPLATE")
@Table(name="TEMPLATE")
public class Template {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEMPlATE_ID")
	private Long templateId;
	
	@Column(name="TEMPLATE_NAME")
	private String templateName;
	
	@Column(name="TEMPLATE_DESCRIPTION")
	@Lob
	private String templateDescription;
	
	@Column(name="TEMPLATE_JSP_PATH")
	private String jspPath;

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}
}
