package com.friendit.services;

import java.util.List;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;

public interface WallService {
	public boolean addWallPost(UserBean ub, WallContents wallContent);
	public List<WallContents> getWallContents(UserBean ub);
	public boolean likePost(Long sl);
	public boolean dislikePost(Long sl);

}
