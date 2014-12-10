package org.com.myapp.service;

import org.com.myapp.model.UserProfile;

public interface UserService {

	UserProfile findUserById(int id);
	UserProfile findUserByName(String name);
	void createUser(UserProfile user);
}
