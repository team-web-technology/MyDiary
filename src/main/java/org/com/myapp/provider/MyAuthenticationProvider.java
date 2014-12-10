package org.com.myapp.provider;

import org.com.myapp.form.User;
import org.com.myapp.model.Role;
import org.com.myapp.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = (User) userAuthenticationService
				.loadUserByUsername(username);

		if (user == null) {
			throw new BadCredentialsException("Invalid username and password.");
		} else if (!encoder.matches(password, user.getPassword())) {
			throw new BadCredentialsException("Invalid username and password.");
		}

		Role userRole = userAuthenticationService
				.loadRoleByUserId(user.getId());
		user.setRole(userRole.getName());
		System.out.println("My Authentication: "+user.getAuthorities().toString());
		
		return new UsernamePasswordAuthenticationToken(user,
				user.getPassword(), user.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	public UserAuthenticationService getUserAuthenticationService() {
		return userAuthenticationService;
	}

	public void setUserAuthenticationService(
			UserAuthenticationService userAuthenticationService) {
		this.userAuthenticationService = userAuthenticationService;
	}

	public BCryptPasswordEncoder getEncoder() {
		return encoder;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

}
