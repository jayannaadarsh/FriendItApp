package com.friendit.bean;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class MessageBean {
	@Id
	@GeneratedValue
	private Long sl;
	private String message;
	private long sender_UID;
	private long receiver_UID;
	@DateTimeFormat
	private Date ceated_dt_tm;
	public MessageBean(String message, long sender_UID, long receiver_UID, Date ceated_dt_tm) {
		super();
		this.message = message;
		this.sender_UID = sender_UID;
		this.receiver_UID = receiver_UID;
		this.ceated_dt_tm = ceated_dt_tm;
	}
	public Long getSl() {
		return sl;
	}
	public void setSl(Long sl) {
		this.sl = sl;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getSender_UID() {
		return sender_UID;
	}
	public void setSender_UID(long sender_UID) {
		this.sender_UID = sender_UID;
	}
	public long getReceiver_UID() {
		return receiver_UID;
	}
	public void setReceiver_UID(long receiver_UID) {
		this.receiver_UID = receiver_UID;
	}
	public Date getCeated_dt_tm() {
		return ceated_dt_tm;
	}
	public void setCeated_dt_tm(Date ceated_dt_tm) {
		this.ceated_dt_tm = ceated_dt_tm;
	}
	@Override
	public String toString() {
		return "MessageBean [sl=" + sl + ", message=" + message + ", sender_UID=" + sender_UID + ", receiver_UID="
				+ receiver_UID + ", ceated_dt_tm=" + ceated_dt_tm + "]";
	}
	

}
