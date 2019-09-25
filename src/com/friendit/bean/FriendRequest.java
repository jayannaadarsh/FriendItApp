package com.friendit.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class FriendRequest {

	@Id
	@GeneratedValue
	private Long sl;
	private long sender_UID;
	private long receiver_UID;
	private boolean accepted;
	@CreationTimestamp
	private Date created_dt_tm;

	public FriendRequest(long sender_UID, long receiver_UID, boolean accepted, Date created_dt_tm) {
		super();
		this.sender_UID = sender_UID;
		this.receiver_UID = receiver_UID;
		this.accepted = accepted;
		this.created_dt_tm = created_dt_tm;
	}

	public FriendRequest() {
		super();
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
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

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Date getCreated_dt_tm() {
		return created_dt_tm;
	}

	public void setCreated_dt_tm(Date created_dt_tm) {
		this.created_dt_tm = created_dt_tm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accepted ? 1231 : 1237);
		result = prime * result + ((created_dt_tm == null) ? 0 : created_dt_tm.hashCode());
		result = prime * result + (int) (receiver_UID ^ (receiver_UID >>> 32));
		result = prime * result + (int) (sender_UID ^ (sender_UID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendRequest other = (FriendRequest) obj;
		if (accepted != other.accepted)
			return false;
		if (created_dt_tm == null) {
			if (other.created_dt_tm != null)
				return false;
		} else if (!created_dt_tm.equals(other.created_dt_tm))
			return false;
		if (receiver_UID != other.receiver_UID)
			return false;
		if (sender_UID != other.sender_UID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendRequest [sl=" + sl + ", sender_UID=" + sender_UID + ", receiver_UID=" + receiver_UID
				+ ", accepted=" + accepted + ", created_dt_tm=" + created_dt_tm + "]";
	}

}
