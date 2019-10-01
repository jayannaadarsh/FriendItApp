package com.friendit.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.UserBean;
import com.friendit.bean.WallContents;
import com.friendit.dao.WallDao;

@Repository
public class WallDaoImpl implements WallDao {
	@Autowired
	SessionFactory sf;

	@Override
	public String putWallpost(WallContents wc) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(wc);
		} catch (Exception e) {
			return "Failed";
		}
		tx.commit();
		session.close();
		return "Success";
	}

	@Override
	public List<WallContents> getWallPosts(long wall_UId) {
		Session session = sf.openSession();
		System.out.println("executing select");
		Query createQuery = session.createQuery("from WallContents where wall_UId=" + wall_UId);
		List<WallContents> resultList = createQuery.getResultList();
		System.out.println("Friend request  " + resultList);
		session.close();
		return resultList;

	}

	@Override
	public boolean updateWallPost(WallContents content) {
		System.out.println(content);
		Session session = sf.openSession();
		Transaction tx =session.beginTransaction();
		session.update(content);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public WallContents getWallPost(Long sl) {
		Session session = sf.openSession();
		System.out.println("executing select");
		Query createQuery = session.createQuery("from WallContents where sl=" + sl);
		Optional uniqueResultOptional = createQuery.uniqueResultOptional();
		WallContents content = (WallContents) uniqueResultOptional.get();
		System.out.println("Friend request  " + content);
		session.close();
		return content;
	}

}
