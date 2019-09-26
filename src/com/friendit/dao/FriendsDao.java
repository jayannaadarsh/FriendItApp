package com.friendit.dao;

import java.util.List;

import com.friendit.bean.FriendRequest;
import com.friendit.bean.UserBean;

public interface FriendsDao {

	public List<UserBean> getFriends(long id);

	public List<UserBean> getFriends(String searchquery);

	public int sendFriendRequest(FriendRequest friendRequest);

	public UserBean verifyFriends(Long sl, Long senderid);

	public int acceptFriendRequest(UserBean ub, Long senderid);
	
	 

}
