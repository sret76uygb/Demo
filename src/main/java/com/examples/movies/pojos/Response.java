package com.examples.movies.pojos;

public class Response {

	private String partnerUtilization;

	private int percentage;

	

	public String getPartnerUtilization() {
		return partnerUtilization;
	}

	public void setPartnerUtilization(String partnerUtilization) {
		this.partnerUtilization = partnerUtilization;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Response [partnerUtilization=" + partnerUtilization + ", percentage=" + percentage + "]";
	}

	

	
	
	
}
