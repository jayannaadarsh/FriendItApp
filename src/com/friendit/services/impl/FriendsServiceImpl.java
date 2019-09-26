package com.friendit.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.FriendRequest;
import com.friendit.bean.FriendsMappingBean;
import com.friendit.bean.UserBean;
import com.friendit.dao.FriendsDao;
import com.friendit.services.FriendsMappingService;
import com.friendit.services.FriendsService;
import com.friendit.services.UserService;

@Service
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	FriendsDao friendsdao;

	@Autowired
	UserService userService;

	@Autowired
	FriendsMappingService friendsMappingService;

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
	public String rejectRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String acceptFriendRequest(UserBean ub, Long senderid) {
		UserBean friends = friendsdao.verifyFriends(ub.getSl(), senderid);
		if (friends == null) {
			return "Request not found";
		}
		int acceptFriendRequest = friendsdao.acceptFriendRequest(ub, senderid);
		if (acceptFriendRequest == 1) {
			FriendsMappingBean friendsBean = new FriendsMappingBean();
			friendsBean.setReceiverId(ub.getSl());
			friendsBean.setSenderId(senderid);
			int saveFriends = friendsMappingService.saveFriends(friendsBean);
			if (saveFriends == 1) {
				return "request accepted";
			}
		}
		return "request accept failed";
	}

}
