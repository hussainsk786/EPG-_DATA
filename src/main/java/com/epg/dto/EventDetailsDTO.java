package com.epg.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Apalya
 *
 */
@XmlRootElement(name = "eventDetails")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EventDetailsDTO {

	private Date startTime;

	private Date endTime;

	private Integer duration;

	private String genre;

	private String eventName;

	private String eventDescription;

	private String language;

	// @XmlJavaTypeAdapter(JaxBDateFormat.class)
	public Date getStartTime() {
		return startTime;
	}

	// @XmlJavaTypeAdapter(JaxBDateFormat.class)
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
		return "EventDetailsCommand [startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration
				+ ", genre=" + genre + ", eventName=" + eventName + ", eventDescription=" + eventDescription
				+ ", language=" + language + "]";
	}

}
