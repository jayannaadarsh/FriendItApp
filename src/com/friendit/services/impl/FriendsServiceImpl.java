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
	FriendsDao friendsdao;

	@Autowired
	UserService userService;

	public List<UserBean> getFriends(long id) {

		return null;
	}

	public List<UserBean> getFriends(String searchquery) {
		return friendsdao.getFriends(searchquery);
	}

	public String sendFriendRequest(UserBean ub, Long receiverId) {
		UserBean userById = userService.getUserById(receiverId);
		System.out.println(userById);
		String status = "";

		if (userById == null) {
			status = "User Not present";
			return status;
		}
		
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setSender_UID(ub.getSl());
		friendRequest.setReceiver_UID(receiverId);
		int sendFriendRequest = friendsdao.sendFriendRequest(friendRequest);
		if (sendFriendRequest == 0) {
			status = "Request sent";
			return status;
		} else {
			status = "Request failed";
			return status;
		}
	}

	@Override
	public List<UserBean> getFriendRequest(UserBean ub) {
		List<UserBean> friends = friendsdao.getFriends(ub.getSl());
		
		return friends;
	}

	@Override
	public String rejectRequest(UserBean ub, Long sender_uid) {
		if(friendsdao.deleteFriendRequest(ub.getSl(), sender_uid)){
			return"Request cancelled";
		}
		return "Something went Wrong";
		
	}
	
	

}
