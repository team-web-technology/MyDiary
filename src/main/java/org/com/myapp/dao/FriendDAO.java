package org.com.myapp.dao;

import java.util.List;

import org.com.myapp.model.UserProfile;
import org.springframework.dao.DataAccessException;

public interface FriendDAO {
	List<UserProfile> findListFriendById(int id) throws DataAccessException;
	//List<UserProfile> findListFriendByName(String name) throws DataAccessException;
	List<UserProfile> searchFriend(int idUser,String nameFriend) throws DataAccessException;
}
