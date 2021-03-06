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
		name = "Group.findByUsername",
		query = "from GROUP_DETAIL g where g.groupName = :name"
	),
	@NamedQuery(
		name = "Group.findAll",
		query = "from GROUP_DETAIL"
	)
})
@Entity(name="GROUP_DETAIL")
@Table(name="GROUP_DETAIL")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_ID")
	private Long groupId;
	
	@Column(name = "GROUP_NAME", unique = false, nullable = false)
	private String groupName;
	@Column(name="GROUP_DESC")
	private String groupDesc;
	
	public String getIdAsString() {
		return new Long(groupId).toString();
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public boolean equals(Group group) {
		if(group.getGroupId() == this.groupId && group.getGroupName() == this.groupName && group.getGroupDesc() == this.groupDesc) {
			return true;
		} else {
			return false;
		}
	}
}