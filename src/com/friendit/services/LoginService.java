package com.friendit.services;
import java.util.List;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;
public interface LoginService {

	public boolean validateLogin(UserBean ub);
	public UserBean getUserByEmail(String email);
	public List<WallContents> getWallPosts(UserBean ub);

}