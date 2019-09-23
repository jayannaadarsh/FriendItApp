package com.friendit.dao;

import com.friendit.bean.UserBean;

public interface LoginDao {
	public UserBean getUserByEmail(String email);

}
