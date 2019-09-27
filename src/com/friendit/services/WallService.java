package com.friendit.services;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;

public interface WallService {
	public boolean addWallPost(UserBean ub, WallContents wallContent); 

}
