package org.com.myapp.service;

import org.com.myapp.dao.UserDao;
import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public UserProfile findUserById(int id) {

		UserProfile user = userDao.findUserById(id);
		return user;
	}

	@Override
	@Transactional
	public UserProfile findUserByName(String email) {

		UserProfile user = userDao.findUserByName(email);
		return user;
	}

	@Override
	@Transactional
	public void createUser(UserProfile user) {
		userDao.createUser(user);

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
