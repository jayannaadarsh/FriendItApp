package com.friendit.services.impl;

import java.util.List;

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
		if (ub != null && wallContent != null) {
			wallContent.setWall_UId(ub.getSl());
			wallDao.putWallpost(wallContent);
			return true;
		}
		return false;
	}

	@Override
	public List<WallContents> getWallContents(UserBean ub) {
		List<WallContents> wallPost = wallDao.getWallPosts(ub.getSl());
		return wallPost;
	}

	@Override
	public boolean likePost(Long sl) {
		WallContents wallPost = wallDao.getWallPost(sl);
		System.out.println("In service 1st line"+wallPost);
		if (wallPost != null) {
			long like = wallPost.getLikes();
			wallPost.setLikes(like + 1);
			wallDao.updateWallPost(wallPost);
		}

		return false;
	}

	@Override
	public boolean dislikePost(Long sl) {
		WallContents wallPost = wallDao.getWallPost(sl);
		if (wallPost != null) {
			long dislikes = wallPost.getDislike();
			wallPost.setDislike(dislikes + 1);
			System.out.println(wallPost.getSl());
			wallDao.updateWallPost(wallPost);
		}

		return false;
	}

}
