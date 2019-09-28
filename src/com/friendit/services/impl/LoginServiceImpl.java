package com.friendit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;
import com.friendit.dao.LoginDao;
import com.friendit.services.LoginService;
import com.friendit.services.WallService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDAO;
	
	@Autowired
	WallService wallservice;

	public boolean validateLogin(UserBean ub) {

		UserBean daoUB = getUserByEmail(ub.getEmail());
		if (daoUB != null) {
			if (daoUB.getEmail().equalsIgnoreCase(ub.getEmail()))
				if (daoUB.getPassword().equals(ub.getPassword())) {
					return true;
				}
		}

		return false;

	}

	public UserBean getUserByEmail(String email) {
		return loginDAO.getUserByEmail(email);

	}

	@Override
	public List<WallContents> getWallPosts(UserBean ub) {
		
		return null;
	}

}
