package com.friendit.services;
import com.friendit.bean.UserBean;
public interface LoginService {

	public boolean validateLogin(UserBean ub);
	public UserBean getUserByEmail(String email);

}
