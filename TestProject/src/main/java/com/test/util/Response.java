package com.test.util;

import java.util.Arrays;

public class Response {
	
	private Boolean isSuccess;
	private String[] error;
	private String successMessage;
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	
	@Override
	public String toString() {
		return "Response [isSuccess=" + isSuccess + ", error=" + Arrays.toString(error) + ", successMessage="
				+ successMessage + "]";
	}
	
}
