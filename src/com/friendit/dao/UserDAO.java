package com.friendit.dao;

import java.util.List;

import com.friendit.bean.UserBean;

public interface UserDAO {
	
	public String saveUser(UserBean ub);
	public List<UserBean> getUsers();
	

}
