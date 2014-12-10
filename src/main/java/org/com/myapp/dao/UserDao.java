package org.com.myapp.dao;

import java.util.List;

import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;
import org.springframework.dao.DataAccessException;

public interface UserDao {

	UserProfile findUserById(int id) throws DataAccessException;

	UserProfile findUserByName(String name) throws DataAccessException;


	
	UserProfile createUser(UserProfile user);
	
	List<User> getUserList(int from, int to);
}
