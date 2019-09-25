package com.friendit.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.UserBean;
import com.friendit.dao.UserDAO;
import com.friendit.services.UserService;
import com.friendit.utility.SendEmail;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	@Autowired
	SendEmail sendmail;

	public boolean createUser(UserBean ub) {
		System.out.println("Inside createStudent");

		List<UserBean> users = dao.getUsers();
		for (UserBean user : users) {
			if (user.getEmail().equalsIgnoreCase(ub.getEmail()))
				return false;

		}
		if(ub.getPassword().equals(ub.getConfirm_password()))
		{
			ub.setCreated_dt_tm(new Date());
			ub.setActive(true);
			dao.saveUser(ub);
			sendmail.sendKey(ub.getEmail());
			return true;
			
		}
		return false;
		
		

	}

}
