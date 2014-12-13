package org.com.myapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.com.myapp.dao.FriendDAO;
import org.com.myapp.model.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService{
	@Autowired
	private FriendDAO friendDAO;

	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}

	@Override
	@Transactional
	public List<UserProfile> findListFriendById(int id) {
		List<UserProfile> userProfileList=friendDAO.findListFriendById(id);
		return userProfileList;
	}

	@Override
	@Transactional
	public List<UserProfile> searchFriend(int idUser, String nameFriend) {
		List<UserProfile> friendList=friendDAO.searchFriend(idUser, nameFriend);
		return friendList;
	}

}
