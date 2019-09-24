package com.friendit.vo;

public class EmailObject {
	
	private String toEmail;
	private String subject;
	private String message;
	public EmailObject(String toEmail, String subject, String message) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.message = message;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((toEmail == null) ? 0 : toEmail.hashCode());
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
		EmailObject other = (EmailObject) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (toEmail == null) {
			if (other.toEmail != null)
				return false;
		} else if (!toEmail.equals(other.toEmail))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EmailObject [toEmail=" + toEmail + ", subject=" + subject + ", message=" + message + "]";
	}
	
	

}
