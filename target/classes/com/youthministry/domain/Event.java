package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="EVENT")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EVENT_ID")
	private Long eventId;
	@Column(name="EVENT_NAME")
	private String eventName;
	@Column(name="EVENT_DESC")
	private String eventDesc;
	@Column(name="START_TIME")
	private Date startTime;
	@Column(name="END_TIME")
	private Date endTime;
	@OneToOne(cascade=CascadeType.ALL)
	private Location location;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "EVENT_GROUP",
	joinColumns = @JoinColumn(name = "EVENT_ID", unique=false),
	inverseJoinColumns = @JoinColumn(name = "GROUP_ID", unique=false))
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)	
	private Collection<Group> groups = new ArrayList<Group>();
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Collection<Group> getGroups() {
		return groups;
	}
	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}
	
}