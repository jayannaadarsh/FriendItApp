package com.friendit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.FriendsMappingBean;
import com.friendit.dao.FriendsMappingDao;
import com.friendit.services.FriendsMappingService;

@Service
public class FriendsMappingServiceImpl implements FriendsMappingService {

	@Autowired
	FriendsMappingDao friendsMappingDao;

	@Override
	public int saveFriends(FriendsMappingBean friendsMappingBean) {
		return friendsMappingDao.saveFriends(friendsMappingBean);
	}

}
