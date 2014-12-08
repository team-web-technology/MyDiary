package org.com.myapp.dao;

import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;
import org.springframework.dao.DataAccessException;

public interface UserDao {

	UserProfile findUserById(int id) throws DataAccessException;

	UserProfile findUserByName(String name) throws DataAccessException;


	void createUser(UserProfile user);
}
