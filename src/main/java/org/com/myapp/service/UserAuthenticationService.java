package org.com.myapp.service;

import java.util.HashSet;
import java.util.Set;

import org.com.myapp.dao.RoleDao;
import org.com.myapp.dao.UserDao;
import org.com.myapp.form.User;
import org.com.myapp.model.Role;
import org.com.myapp.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserProfile userProfile = userDao.findUserByName(username);

		User user = new User();
		if(userProfile != null){
			user.setDetails(userProfile);
		}
		

		return user;
	}

	public Role loadRoleByUserId(int id){
		
		Role r = roleDao.findRoleById(id);
		return r;
	}
	
	public RoleDao getRoleDao() {
		return roleDao;
	}



	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// set RoLE for user
	public Set<GrantedAuthority> getAuthorities(String role) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

}
