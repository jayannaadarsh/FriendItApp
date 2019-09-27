package com.friendit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
