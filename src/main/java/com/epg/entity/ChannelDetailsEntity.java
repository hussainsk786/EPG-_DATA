package com.epg.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Apalya
 *
 */
@Entity
@Table(name = "channel_details")
public class ChannelDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cid_seq")
	@SequenceGenerator(name = "cid_seq", sequenceName = "channelId_seq", initialValue = 101, allocationSize = 1)
	@Column(name = "channel_id")
	private Integer channelID;
	@Column(name = "channel_name")
	private String channelName;
	@Column(name = "Channel_logo")
	private String channelLogo;
	@Column(name = "Genre")
	private String genre;
	@Column(name = "Language")
	private String language;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "channel", fetch = FetchType.LAZY)
	private Set<EventDetailsEntity> event;

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

	public Set<EventDetailsEntity> getEvent() {
		return event;
	}

	public void setEvent(Set<EventDetailsEntity> event) {
		this.event = event;
	}

	public Integer getChannelID() {
		return channelID;
	}

	public String getChannelName() {
		return channelName;
	}

	public String getChannelLogo() {
		return channelLogo;
	}

	public void setChannelID(Integer channelID) {
		this.channelID = channelID;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public void setChannelLogo(String channelLogo) {
		this.channelLogo = channelLogo;
	}

	@Override
	public String toString() {
		return "ChannelDetailsEntity [channelID=" + channelID + ", channelName=" + channelName + ", channelLogo="
				+ channelLogo + ", genre=" + genre + ", language=" + language + ", event=" + event + "]";
	}

}
