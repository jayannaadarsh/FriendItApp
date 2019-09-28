package com.friendit.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class UserBean {

	@Id
	@GeneratedValue
	private Long sl;

	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	@Transient
	private String confirm_password;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	@NotEmpty
	private String city;
	@NotEmpty
	private String dob;
	@NotEmpty
	private String gender;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<UserBean> friends;
	private Date created_dt_tm;
	private boolean isActive;

	@OneToOne(mappedBy = "wallid")
	private WallContents wallcontent;

	public UserBean(String email, String password, String confirm_password, String firstname, String lastname,
			String city, String dob, String gender, List<UserBean> friends, Date created_dt_tm, boolean isActive) {
		super();
		this.email = email;
		this.password = password;
		this.confirm_password = confirm_password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.dob = dob;
		this.gender = gender;
		this.friends = friends;
		this.created_dt_tm = created_dt_tm;
		this.isActive = isActive;
	}

	public UserBean() {
		super();
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<UserBean> getFriends() {
		return friends;
	}

	public void setFriends(List<UserBean> friends) {
		this.friends = friends;
	}

	public Date getCreated_dt_tm() {
		return created_dt_tm;
	}

	public void setCreated_dt_tm(Date created_dt_tm) {
		this.created_dt_tm = created_dt_tm;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((confirm_password == null) ? 0 : confirm_password.hashCode());
		result = prime * result + ((created_dt_tm == null) ? 0 : created_dt_tm.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		UserBean other = (UserBean) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (confirm_password == null) {
			if (other.confirm_password != null)
				return false;
		} else if (!confirm_password.equals(other.confirm_password))
			return false;
		if (created_dt_tm == null) {
			if (other.created_dt_tm != null)
				return false;
		} else if (!created_dt_tm.equals(other.created_dt_tm))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBean [sl=" + sl + ", email=" + email + ", password=" + password + ", confirm_password="
				+ confirm_password + ", firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + ", dob="
				+ dob + ", gender=" + gender + ", friends=" + friends + ", created_dt_tm=" + created_dt_tm
				+ ", isActive=" + isActive + "]";
	}

}
