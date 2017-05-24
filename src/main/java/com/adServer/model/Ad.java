package com.adServer.model;

import java.util.Date;

public class Ad {

	private Long partnerId;
	private String addContent;
	private int duration;

	public Ad(long partnerId, String addContent,int duration) {
		this.partnerId = partnerId;
		this.addContent = addContent;
		this.duration = duration;

	}

	public Ad() {
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getAddContent() {
		return addContent;
	}

	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}