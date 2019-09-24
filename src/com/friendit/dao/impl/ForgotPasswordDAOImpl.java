package com.friendit.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.UserBean;
import com.friendit.dao.ForgotPasswordDao;
@Repository
public class ForgotPasswordDAOImpl implements ForgotPasswordDao {

	@Autowired
	SessionFactory sf;
	@Override
	public UserBean getUserByEmail(String email) {

		System.out.println(email);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Optional uniqueResultOptional = session.createQuery("from UserBean where email=:email")
				.setParameter("email", email).uniqueResultOptional();
		UserBean daoUB = (UserBean) uniqueResultOptional.get();
		return daoUB;
		
	}
	@Override
	public String updateUSer(UserBean ub) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ub);
		tx.commit();
		session.close();
		return "SUCCESS";
		
	}
	
	

}
