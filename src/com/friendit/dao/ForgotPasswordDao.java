package com.friendit.dao;

import com.friendit.bean.UserBean;

public interface ForgotPasswordDao {

	public UserBean getUserByEmail(String email);
	public String updateUSer(UserBean ub);

}
