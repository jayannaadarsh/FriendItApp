package com.friendit.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Wall_Contents")
public class WallContents {

	private String content;
	@CreationTimestamp
	private Date createdDate;
	private long likes;
	private long dislike;
	private long wall_UId;
	private long post_UID;
	@Id
	@GeneratedValue
	private Long sl;
	
	@OneToOne
	@JoinColumn()
	private UserBean wallid;

	
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

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public UserBean getWallid() {
		return wallid;
	}

	public void setWallid(UserBean wallid) {
		this.wallid = wallid;
	}

	@Override
	public String toString() {
		return "WallContents [content=" + content + ", createdDate=" + createdDate + ", likes=" + likes + ", dislike="
				+ dislike + ", wall_UId=" + wall_UId + ", post_UID=" + post_UID + ", sl=" + sl + ", wallid=" + wallid
				+ "]";
	}


}
