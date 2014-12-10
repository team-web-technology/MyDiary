package org.com.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.com.myapp.dao.RoleDao;
import org.com.myapp.dao.UserDao;
import org.com.myapp.form.ROLE;
import org.com.myapp.form.RegisterForm;
import org.com.myapp.form.User;
import org.com.myapp.hash.HashCode;
import org.com.myapp.model.Role;
import org.com.myapp.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private HashCode hashCode;

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
	public UserProfile createUser(UserProfile user) {
		userDao.createUser(user);
		return user;

	}

	@Override
	public User createUser(RegisterForm registerForm) {

		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setEmail(registerForm.getEmail());
		user.setPassword(hashCode.getHashPassword(registerForm.getPassword()));
		user.setEnabled(true);

		Role r = roleDao.findRoleByName(ROLE.ROLE_USER.toString());
		user.setRole(r.getName());

		UserProfile userProfile = user.getUserProfile(r);
		createUser(userProfile);

		user.setId(userProfile.getId());
		return user;
	}

	@Override
	@Transactional
	public ArrayList<User> getUserList(int from, int to) {

		ArrayList<User> uList = new ArrayList<User>();

		List<User> users = userDao.getUserList(from, to);
		if (users != null) {
			uList = new ArrayList<User>(users);
		}

		return uList;
	}

	@Override
	public Boolean autoLogin(User user) {

		System.out.println("UserService - AutoLogin: " + user.getId());

		// set authentication here
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user, user.getPassword(), user.getAuthorities());

		// redirect into secured main page if authentication successful
		if (token.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(token);

			return true;
		}

		return false;

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public HashCode getHashCode() {
		return hashCode;
	}

	public void setHashCode(HashCode hashCode) {
		this.hashCode = hashCode;
	}

	
	
}
