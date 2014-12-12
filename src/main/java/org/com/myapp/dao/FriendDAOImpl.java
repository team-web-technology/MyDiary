package org.com.myapp.dao;

import java.util.List;

import org.com.myapp.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<UserProfile> findListFriendById(int id)
			throws DataAccessException {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		/*
		 * List<UserProfile> userProfileList=
		 * session.createQuery("from UserProfile as up, Friend as f " +
		 * "where f.UserId="+id+" and up.id=f.FriendId").list();
		 */
		List<UserProfile> userProfileList = session
				.createSQLQuery(
						"select * from userprofile u,friend f where u.id=f.FriendId and f.UserId= :id ")
				.addEntity(UserProfile.class).setParameter("id", id).list();
		return userProfileList;
	}

	public List<UserProfile> searchFriend(int idUser, String nameFriend)
			throws DataAccessException {
		Session session = this.sessionFactory.openSession();
		List<UserProfile> friendList = null;
		List<UserProfile> userProfileList = session.createQuery(
				"from UserProfile as up, Friend as f " + "where f.UserId="
						+ idUser + " and up.id=f.FriendId").list();
		for (UserProfile up : userProfileList) {
			if (up.getUsername() == nameFriend)
				friendList.add(up);
		}
		return friendList;

	}

}
