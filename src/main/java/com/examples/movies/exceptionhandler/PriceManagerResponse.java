/**
 * 
 */
package com.examples.movies.exceptionhandler;

import com.examples.movies.pojos.TvcResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

/**
 * @author Anup Kumar Gupta
 * Dec 11, 2019 PriceManagerResponse.java
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceManagerResponse {

	private String responseCode = null;
	private String messages = null;
	private Collection<?> result = null;

	private String error;

	private Integer status;

	private String timestamp;
	private String userId;
	private Boolean isTvc;
	private String partnerUtilization;
	private Integer percentage;

	public String getPartnerUtilization() {
		return partnerUtilization;
	}
	public void setPartnerUtilization(String partnerUtilization) {
		this.partnerUtilization = partnerUtilization;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
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
	public PriceManagerResponse(String responseCode, String messages) {
		super();
		this.responseCode = responseCode;
		this.messages = messages;
	}
	public PriceManagerResponse(String userId,Boolean isTvc) {
		super();
		this.userId = userId;
		this.isTvc=isTvc;
	}
	public PriceManagerResponse(String partnerUtilization,Integer percentage) {
		super();
		this.partnerUtilization = partnerUtilization;
		this.percentage=percentage;
	}

	public PriceManagerResponse(String responseCode, String messages, Collection<?> result) {
		super();
		this.responseCode = responseCode;
		this.messages = messages;
		this.result = result;
	}

	public PriceManagerResponse() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}

	/**
	 * @return the result
	 */
	public Collection<?> getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Collection<?> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PriceManagerResponse [responseCode=" + responseCode + ", messages=" + messages + ", result=" + result
				+ ", error=" + error + ", status=" + status + ", timestamp=" + timestamp + ", userId=" + userId
				+ ", isTvc=" + isTvc + ", partnerUtilization=" + partnerUtilization + ", percentage=" + percentage
				+ "]";
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}