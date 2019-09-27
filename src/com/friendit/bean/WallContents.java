package com.friendit.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Wall_Contents")
public class WallContents {

	private String content;
	@CreationTimestamp
	private Date createdDate;
	private long like;
	private long dislike;
	private long wall_UId;
	private long post_UID;
	@Id
	@GeneratedValue
	private Long sl;

	public WallContents(String content, Date createdDate, long like, long dislike, long wall_UId, long post_UID) {
		super();
		this.content = content;
		this.createdDate = createdDate;
		this.like = like;
		this.dislike = dislike;
		this.wall_UId = wall_UId;
		this.post_UID = post_UID;
	}

	public WallContents() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getLike() {
		return like;
	}

	public void setLike(long like) {
		this.like = like;
	}

	public long getDislike() {
		return dislike;
	}

	public void setDislike(long dislike) {
		this.dislike = dislike;
	}

	public long getWall_UId() {
		return wall_UId;
	}

	public void setWall_UId(long wall_UId) {
		this.wall_UId = wall_UId;
	}

	public long getPost_UID() {
		return post_UID;
	}

	public void setPost_UID(long post_UID) {
		this.post_UID = post_UID;
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (int) (dislike ^ (dislike >>> 32));
		result = prime * result + (int) (like ^ (like >>> 32));
		result = prime * result + (int) (post_UID ^ (post_UID >>> 32));
		result = prime * result + (int) (wall_UId ^ (wall_UId >>> 32));
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
		WallContents other = (WallContents) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (dislike != other.dislike)
			return false;
		if (like != other.like)
			return false;
		if (post_UID != other.post_UID)
			return false;
		if (wall_UId != other.wall_UId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WallContents [content=" + content + ", createdDate=" + createdDate + ", like=" + like + ", dislike="
				+ dislike + ", wall_UId=" + wall_UId + ", post_UID=" + post_UID + ", sl=" + sl + "]";
	}

}
