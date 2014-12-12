package org.com.myapp.service;

import java.util.List;

import org.com.myapp.model.UserProfile;

public interface FriendService {
	List<UserProfile> findListFriendById(int id);
	List<UserProfile> searchFriend(int idUser,String nameFriend);
}
