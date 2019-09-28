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
		System.out.println("executing select");
		Query createQuery = session
				.createQuery("from UserBean where sl in(select sender_UID from FriendRequest where receiver_UID =" + id
						+ " and accepted=false)");
		List resultList = createQuery.getResultList();
		System.out.println("Friend request  " + resultList);
		session.close();
		return resultList;

	}

	public List<UserBean> getFriends(String searchquery) {
		Session session = sf.openSession();
		System.out.println("executing select" + searchquery);
		String query = "from UserBean where email like ? or firstname like ? or lastname like ?";
		Query createQuery = session.createQuery(query);
		createQuery.setString(0, "%" + searchquery + "%");
		createQuery.setString(1, "%" + searchquery + "%");
		createQuery.setString(2, "%" + searchquery + "%");
		// System.out.println(setParameter);
		List<UserBean> resultList = createQuery.getResultList();
		// System.out.println(resultList);
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

	@Override
	public boolean deleteFriendRequest(Long receiver_uid, Long sender_uid) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select");
		// from FriendRequest where receiver_UID ="+receiver_uid+" sender_UID =
		// "+sender_uid+"and accepted=false
		Query createQuery = session.createQuery("from FriendRequest where receiver_UID =" + receiver_uid
				+ " and sender_UID = " + sender_uid + " and accepted = false");
		System.out.println(createQuery);
		FriendRequest request = (FriendRequest) createQuery.getSingleResult();
		System.out.println("Deleting this request " + request);
		session.delete(request);
		tx.commit();
		session.close();
		return true;
	}

	public UserBean verifyFriends(Long sl, Long senderid) {
		Session session = sf.openSession();
		System.out.println("executing select");
		Query createQuery = session
				.createQuery("from UserBean where sl in(select sender_UID from FriendRequest where receiver_UID =" + sl
						+ " and sender_UID =" + senderid + "and accepted=false)");
		UserBean resultList = (UserBean) createQuery.getSingleResult();
		System.out.println("Friend request  " + resultList);
		session.close();
		return resultList;
	}

	@Override
	public int acceptFriendRequest(UserBean ub, Long senderid) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select");
		Query createQuery = session.createQuery("update FriendRequest set accepted = true where receiver_UID ="
				+ ub.getSl() + " and sender_UID =" + senderid + "and accepted=false)");
		int executeUpdate = createQuery.executeUpdate();
		tx.commit();
		session.close();
		return executeUpdate;

	}

}
