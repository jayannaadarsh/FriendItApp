package com.friendit.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "friends_mapping")
public class FriendsMappingBean {

	@Id
	@GeneratedValue
	private int id;
	private long senderId;
	private long receiverId;

	public int getId() {
		return id;
	}

	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

}
