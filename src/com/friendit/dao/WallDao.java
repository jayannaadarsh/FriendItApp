package com.friendit.dao;

import java.util.List;

import com.friendit.bean.WallContents;

public interface WallDao {
	public String putWallpost(WallContents wc);
	public List<WallContents> getWallPosts(long wall_UId);
	public boolean updateWallPost(WallContents content);
	public WallContents getWallPost(Long sl);

}
