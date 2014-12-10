package org.com.myapp.service;

import java.util.ArrayList;

import org.com.myapp.form.RegisterForm;
import org.com.myapp.form.User;
import org.com.myapp.model.UserProfile;

public interface UserService {

	UserProfile findUserById(int id);
	UserProfile findUserByName(String name);
	UserProfile createUser(UserProfile user);
	User createUser(RegisterForm registerForm);
	ArrayList<User> getUserList(int from,int to);
	
	Boolean autoLogin(User user);
	
	
}
