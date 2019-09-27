package com.friendit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;
import com.friendit.dao.WallDao;
import com.friendit.services.WallService;

@Service
public class WallServiceImpl implements WallService {
	@Autowired
	WallDao wallDao;

	@Override
	public boolean addWallPost(UserBean ub, WallContents wallContent) {
		if(ub!=null && wallContent!=null){
			return true;
		}
		return false;
	}

}
