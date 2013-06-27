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
		name = "Image.findAll",
		query = "from Image"
	)
})
@Entity
@Table(name="IMAGE")
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMAGE_ID")
	private Long imageId;
	@Column(name="IMAGE_NAME")
	private String imageName;
	@Column(name="PATH_TO_IMAGE")
	private String pathToImage;
	@Column(name="ALT_TEXT")
	private String altText;
	@Column(name="TITLE_TEXT")
	private String titleText;
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long id) {
		this.imageId = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
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