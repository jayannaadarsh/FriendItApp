package com.friendit.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.FriendRequest;
import com.friendit.bean.UserBean;
import com.friendit.dao.FriendsDao;

@Repository
public class FriendsDAOImpl implements FriendsDao {

	@Autowired
	SessionFactory sf;

	public List<UserBean> getFriends(long id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select");
		Query createQuery = session.createQuery("from UserBean where id=:id");
		Query setParameter = createQuery.setParameter("id", id);
		List resultList = setParameter.getResultList();
		return resultList;

	}

	public List<UserBean> getFriends(String searchquery) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select" + searchquery);
		String query = "from UserBean where email like ? or firstname like ? or lastname like ?";
		Query createQuery = session.createQuery(query);
		createQuery.setString(0, "%" + searchquery + "%");
		createQuery.setString(1, "%" + searchquery + "%");
		createQuery.setString(2, "%" + searchquery + "%");
		// System.out.println(setParameter);
		List<UserBean> resultList = createQuery.getResultList();
		// System.out.println(resultList);
		tx.commit();
		session.close();
		return resultList;

	}

	public int sendFriendRequest(FriendRequest friendRequest) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(friendRequest);
		} catch (Exception e) {
			return 1;
		}
		tx.commit();
		session.close();
		return 0;
	}

}
