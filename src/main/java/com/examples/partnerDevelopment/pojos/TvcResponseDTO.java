package com.examples.partnerDevelopment.pojos;

public class TvcResponseDTO {

	private String userId;

	private Boolean isTvc;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getIsTvc() {
		return isTvc;
	}

	public void setIsTvc(Boolean isTvc) {
		this.isTvc = isTvc;
	}

	@Override
	public String toString() {
		return "TvcResponse [userId=" + userId + ", isTvc=" + isTvc + "]";
	}

	}
