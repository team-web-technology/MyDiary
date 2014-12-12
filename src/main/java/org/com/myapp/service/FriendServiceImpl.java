package org.com.myapp.service;

import java.util.List;

import org.com.myapp.dao.FriendDAO;
import org.com.myapp.model.UserProfile;

public class FriendServiceImpl implements FriendService{
	private FriendDAO friendDAO;
	

	public FriendDAO getFriendDAO() {
		return friendDAO;
	}

	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}

	@Override
	public List<UserProfile> findListFriendById(int id) {
		List<UserProfile> userProfileList=friendDAO.findListFriendById(id);
		return userProfileList;
	}

	@Override
	public List<UserProfile> searchFriend(int idUser, String nameFriend) {
		List<UserProfile> friendList=friendDAO.searchFriend(idUser, nameFriend);
		return friendList;
	}

}
