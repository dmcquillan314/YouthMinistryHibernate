package com.youthministry.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@NamedQueries({
	@NamedQuery(
		name = "Event.findByName",
		query = "from Event e where e.eventName = :name"
	),
	@NamedQuery(
		name = "Event.findAll",
		query = "from Event"
	)
})
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
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="LOCATION_ID")
	private Location location;

	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "EVENT_GROUP",
		joinColumns = @JoinColumn(name = "EVENT_ID"),
		inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
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