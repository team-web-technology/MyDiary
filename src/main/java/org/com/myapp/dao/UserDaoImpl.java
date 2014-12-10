package org.com.myapp.dao;

import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// find user by id
	@Override
	
	public UserProfile findUserById(int id)throws DataAccessException {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		
		User user = (User) session.createCriteria(UserProfile.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	// find user by email
	@Override
	public UserProfile findUserByName(String email)throws DataAccessException {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		UserProfile user = (UserProfile) session.createCriteria(UserProfile.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void createUser(UserProfile user) throws DataAccessException {
		Session session =sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		
		
		session.getTransaction().commit();
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
