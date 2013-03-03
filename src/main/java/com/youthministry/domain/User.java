package com.youthministry.domain;
 
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Long userId;
	@Column(name = "USER_NAME", nullable = false, length = 50)
	private String username;
	@Column(name = "PASSWORD", nullable = false, length = 50)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UserProfile userProfile;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Role role;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Group> groups = new ArrayList<Group>();
	
	public User() {
		
	}
	
	public User(String username, String password, UserProfile userProfile, Role role) {
		this.username = username;
		this.password = password;
		this.userProfile = userProfile;
		this.role = role;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public Collection<Group> getGroups() {
		return groups;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}
	
}