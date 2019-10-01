package com.friendit.services;

import java.util.List;

import com.friendit.bean.UserBean;

public interface FriendsService {
	public List<UserBean> getFriends(long id);

	public List<UserBean> getFriends(String searchquery);

	public String sendFriendRequest(UserBean ub, Long receiverId);

	public List<UserBean> getFriendRequest(UserBean ub);

	public String rejectRequest(UserBean ub, Long sender_uid);

	public String acceptFriendRequest(UserBean ub, Long senderid);

}
