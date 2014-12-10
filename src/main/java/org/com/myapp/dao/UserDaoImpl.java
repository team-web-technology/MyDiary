package org.com.myapp.dao;

import java.util.List;

import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// find user by id
	@Override
	public UserProfile findUserById(int id) throws DataAccessException {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		UserProfile user = (UserProfile) session
				.createCriteria(UserProfile.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	// find user by email
	@Override
	public UserProfile findUserByName(String email) throws DataAccessException {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		UserProfile user = (UserProfile) session
				.createCriteria(UserProfile.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
		session.getTransaction().commit();
		return user;
	}

	@Override
	public UserProfile createUser(UserProfile user) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();

		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(int from, int to) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		/*
		 * List<UserProfile> users = session .createSQLQuery( "select u.*,r.* "
		 * + "from userprofile u,role r " + "where u.IdRole = r.idauthority")
		 * .addEntity(UserProfile.class).setFirstResult(from)
		 * .setMaxResults(to).list();
		 */
		List<User> users = session
				.createSQLQuery("call getUserList(:from,:to)")
				.addEntity(User.class).setParameter("from", from)
				.setParameter("to", to)
				.setResultTransformer(Transformers.aliasToBean(User.class))
				.list();
		session.getTransaction().commit();

		return users;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
