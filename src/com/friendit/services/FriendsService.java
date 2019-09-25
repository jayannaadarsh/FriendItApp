package com.friendit.services;

import java.util.List;

import com.friendit.bean.UserBean;

public interface FriendsService {
	public List<UserBean> getFriends(long id);
	public List<UserBean> getFriends(String searchquery);

}
