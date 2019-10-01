package com.friendit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.FriendsMappingBean;
import com.friendit.dao.FriendsMappingDao;

@Repository
public class FriendsMappingDaoImpl implements FriendsMappingDao {

	@Autowired
	SessionFactory sf;

	@Override
	public int saveFriends(FriendsMappingBean friendsMappingBean) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(friendsMappingBean);
		} catch (Exception e) {
			return 0;
		}
		tx.commit();
		session.close();
		return 1;
	}

}
