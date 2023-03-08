package com.epg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "event_details")
public class EventDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eid_seq")
	@SequenceGenerator(name = "eid_seq", sequenceName = "event_seq", initialValue = 201, allocationSize = 1)
	@Column(name = "event_id")
	private Integer eventId;

	@Column(name = "start_time")
	private Date startTime;
	@Column(name = "end_time")
	private Date endTime;
	@Column(name = "duration")
	private Integer duration;
	@Column(name = "genre")
	private String genre;
	@Column(name = "event_name")
	private String eventName;
	@Column(name = "event_descri")
	private String eventDescription;
	@Column(name = "language")
	private String language;

	@ManyToOne
	@JoinColumn(name = "channel_id")
	private ChannelDetailsEntity channel;

	public Integer getEventId() {
		return eventId;
	}

	public ChannelDetailsEntity getChannel() {
		return channel;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public void setChannel(ChannelDetailsEntity channel) {
		this.channel = channel;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public String getGenre() {
		return genre;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public String getLanguage() {
		return language;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "EventDetailsEntity [eventId=" + eventId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", duration=" + duration + ", genre=" + genre + ", eventName=" + eventName + ", eventDescription="
				+ eventDescription + ", language=" + language + ", channel=" + channel + "]";
	}

}
