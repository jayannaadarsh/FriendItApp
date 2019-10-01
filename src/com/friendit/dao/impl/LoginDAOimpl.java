package com.friendit.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendit.bean.UserBean;
import com.friendit.dao.LoginDao;

@Repository
public class LoginDAOimpl implements LoginDao {
	@Autowired
	SessionFactory sf;

	public UserBean getUserByEmail(String email) {
		System.out.println(email);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Optional uniqueResultOptional = session.createQuery("from UserBean where email=:email")
				.setParameter("email", email).uniqueResultOptional();
		UserBean daoUB = (UserBean) uniqueResultOptional.get();
		session.close();
		return daoUB;
	}

}
