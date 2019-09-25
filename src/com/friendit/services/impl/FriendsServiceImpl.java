package com.friendit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.UserBean;
import com.friendit.dao.FriendsDao;
import com.friendit.services.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService {
@Autowired
FriendsDao friends;
	@Override
	public List<UserBean> getFriends(long id) {
		
		return null;
	}

	@Override
	public List<UserBean> getFriends(String searchquery) {
		return friends.getFriends(searchquery);
	}

}
