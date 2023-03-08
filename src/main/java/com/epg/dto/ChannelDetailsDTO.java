package com.epg.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Apalya
 *
 */
@XmlRootElement(name = "channelDetails")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ChannelDetailsDTO {

	private String channelName;

	private String channelLogo;

	private String genre;
	private String language;

	private List<EventDetailsDTO> eventDetails;

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getChannelLogo() {
		return channelLogo;
	}

	public List<EventDetailsDTO> getEventDetails() {
		return eventDetails;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setChannelLogo(String channelLogo) {
		this.channelLogo = channelLogo;
	}

	public void setEventDetails(List<EventDetailsDTO> eventDetails) {
		this.eventDetails = eventDetails;
	}

	@Override
	public String toString() {
		return "ChannelDetailsDTO [channelName=" + channelName + ", channelLogo=" + channelLogo + ", genre=" + genre
				+ ", language=" + language + ", eventDetails=" + eventDetails + "]";
	}

}
