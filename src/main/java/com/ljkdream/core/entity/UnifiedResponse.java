package com.ljkdream.core.entity;

/**
 * 开放API所使用的统一的响应数据格式
 * */
public class UnifiedResponse implements UnifiedResponseCode {

	/** 响应码（必选字段）*/
	private int status;
	
	/** 响应码提示信息*/
	private String message;
	
	/** 附件信息，其他拓展信息，可选字段，一般可以是MAP*/
	private Object attachment;
	
	public UnifiedResponse() {
		this.status = RC_SUCC;
		this.message = "成功";
	}
	
	public UnifiedResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public UnifiedResponse(int status, String message, Object attachment) {
		this.status = status;
		this.message = message;
		this.attachment = attachment;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getAttachment() {
		return attachment;
	}

	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}
	
}