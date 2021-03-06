package com.youthministry.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
		name = "Role.findByName",
		query = "from Role r where r.name = :name"
	),
	@NamedQuery(
		name = "Role.findAll",
		query = "from Role"
	)
})
@Entity
@Table(name="ROLE")
public class Role
{
	@Id
	@GeneratedValue
	@Column(name="ROLE_ID")
	private Long id;
	
	@Column(name="ROLE", unique=true, nullable=false)
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean equals(Role role) {
		if(role.getName() == this.name && role.getId() == this.id) {
			return true;
		} else {
			return false;
		}
	}
}