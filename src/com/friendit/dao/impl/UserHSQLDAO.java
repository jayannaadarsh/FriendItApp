package com.friendit.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.UserBean;
import com.friendit.dao.UserDAO;

@Repository
public class UserHSQLDAO implements UserDAO {

	@Autowired
	SessionFactory sf;

	public String saveUser(UserBean ub) {

		System.out.println("Inside saveStudent dao");
		Session session = sf.openSession();
		System.out.println("opening session");
		Transaction tx = session.beginTransaction();
		System.out.println("begin transaction");
		System.out.println(ub);
		session.save(ub);
		System.out.println(session.save(ub).toString());
		System.out.println("saving bean");
		tx.commit();
		System.out.println("commit");
		session.close();
		System.out.println("Inside saveStudent dao - - -end");
		return "Usersave.sucess";

	}

	public List<UserBean> getUsers() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select");
		List<UserBean> resultList = session.createQuery("from UserBean").getResultList();
		System.out.println(resultList);
		session.close();
		return resultList;

	}

	public UserBean getUserById(Long receiverId) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("executing select");
		UserBean resultList =(UserBean) session.createQuery("from UserBean where id = "+receiverId +"").getSingleResult();
		System.out.println(resultList);
		session.close();
		return resultList;
	}

}
