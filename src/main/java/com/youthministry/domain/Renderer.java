package com.youthministry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
		name = "Renderer.findByName",
		query = "from Renderer r where r.rendererName = :name"
	),
	@NamedQuery(
		name = "Renderer.findAll",
		query = "from Renderer"
	)
})
@Entity
@Table(name="RENDERER")
public class Renderer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RENDERER_ID")
	private Long rendererId;
	
	@Column(name="RENDERER_NAME")
	private String rendererName;
	
	@Column(name="RENDERER_DESCRIPTION")
	private String rendererDescription;
	
	@Column(name="RENDERER_JSP_PATH")
	private String rendererJspPath;

	public Long getRendererId() {
		return rendererId;
	}

	public void setRendererId(Long rendererId) {
		this.rendererId = rendererId;
	}

	public String getRendererName() {
		return rendererName;
	}

	public void setRendererName(String rendererName) {
		this.rendererName = rendererName;
	}

	public String getRendererDescription() {
		return rendererDescription;
	}

	public void setRendererDescription(String rendererDescription) {
		this.rendererDescription = rendererDescription;
	}

	public String getRendererJspPath() {
		return rendererJspPath;
	}

	public void setRendererJspPath(String rendererJspPath) {
		this.rendererJspPath = rendererJspPath;
	}

}
