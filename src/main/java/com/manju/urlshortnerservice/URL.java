package com.manju.urlshortnerservice;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class URL {
	
	
	@GeneratedValue
	private Long id;
	private String originalURL;
	@Id
	private String shortenURL;
	private Date timeStamp;
	
	
	public URL() {

	}
	
	
	public URL(String originalURL) {
		this.originalURL = originalURL;
	}


	public URL(String originalURL, String shortenURL) {
		super();
		this.originalURL = originalURL;
		this.shortenURL = shortenURL;
	}
	
	public URL(String originalURL, String shortenURL, Date timeStamp) {
		super();
		this.originalURL = originalURL;
		this.shortenURL = shortenURL;
		this.timeStamp = timeStamp;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOriginalURL() {
		return originalURL;
	}
	
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	
	public String getShortenURL() {
		return shortenURL;
	}
	
	public void setShortenURL(String shortenURL) {
		this.shortenURL = shortenURL;
	}

	@Override
	public String toString() {
		return "originalURL=" + originalURL + "/shortenURL=" + shortenURL ;
	}
	
	
	
}
