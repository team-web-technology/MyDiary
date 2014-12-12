	package org.com.myapp.dao;

import java.util.List;

import org.com.myapp.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class FriendDAOImpl implements FriendDAO{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	@Autowired
	public List<UserProfile> findListFriendById(int id) throws DataAccessException {
		Session session=this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserProfile> userProfileList= session.createQuery("from UserProfile as up, Friend as f "
				+ "where f.UserId="+id+" and up.id=f.FriendId").list();
		return userProfileList;
	}
	@Override
	public List<UserProfile> searchFriend(int idUser,String nameFriend) throws DataAccessException {
			Session session=this.sessionFactory.openSession();
			List<UserProfile> friendList=null;
			List<UserProfile> userProfileList= session.createQuery("from UserProfile as up, Friend as f "
					+ "where f.UserId="+idUser+" and up.id=f.FriendId").list();
			for(UserProfile up:userProfileList){
				if(up.getUsername()==nameFriend)
					friendList.add(up);
			}
			return friendList;
			
	}



}
