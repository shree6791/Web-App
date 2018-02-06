package com.shree.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shree.model.Login;

@Repository
public class LoginDAOImpl implements LoginDao {

	// inject session factory dependency to StudentDAOImpl Cls
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean getUser(String userName, String password) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Search for User Name and Password ... Case insensitive
		Query query = currentSession.createQuery("from Login where userName = :userName and password = :password",
				Login.class);

		query.setParameter("userName", userName);
		query.setParameter("password", password);

		try {
			// execute query and get result list
			Login login = (Login) query.getSingleResult();
		} catch (NoResultException nre) {
			return false;
		}

		return true;

	}

}
