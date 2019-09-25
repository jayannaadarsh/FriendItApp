package com.friendit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.FriendRequest;
import com.friendit.bean.UserBean;
import com.friendit.dao.FriendsDao;
import com.friendit.services.FriendsService;
import com.friendit.services.UserService;

@Service
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	FriendsDao friends;

	@Autowired
	UserService userService;

	public List<UserBean> getFriends(long id) {

		return null;
	}

	public List<UserBean> getFriends(String searchquery) {
		return friends.getFriends(searchquery);
	}

	public String sendFriendRequest(UserBean ub, Long receiverId) {
		UserBean userById = userService.getUserById(receiverId);
		String status = "";

		if (userById == null) {
			status = "User Not present";
			return status;
		}
		
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setSender_UID(ub.getSl());
		friendRequest.setReceiver_UID(receiverId);
		int sendFriendRequest = friends.sendFriendRequest(friendRequest);
		if (sendFriendRequest == 0) {
			status = "Request sent";
			return status;
		} else {
			status = "Request failed";
			return status;
		}
	}

}
