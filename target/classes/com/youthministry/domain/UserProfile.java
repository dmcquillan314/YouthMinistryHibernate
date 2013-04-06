package com.youthministry.domain;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "USER_PROFILE")
public final class UserProfile {

	@Id
	@GeneratedValue
	@Column(name="USER_PROFILE_ID")
	private Long userProfileId;
	@Column(name="FIRST_NAME", nullable=false, length=55)
	private String firstName;
	@Column(name="LAST_NAME", nullable=false, length=55)
	private String lastName;
	
	public UserProfile() {
	}
	
	public UserProfile(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}