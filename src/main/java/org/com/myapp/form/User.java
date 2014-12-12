package org.com.myapp.form;

import java.util.Collection;

import org.com.myapp.model.Role;
import org.com.myapp.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String role;
	private String username;
	private String password;
	private String email;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;

	public User() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(this.getRole().toUpperCase());
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDetails(UserProfile userProfile) {
		
		this.id = userProfile.getId();
		this.username = userProfile.getUsername();
		this.email = userProfile.getEmail();
		this.password = userProfile.getPassword();
		this.enabled = userProfile.getEnabled();
		this.accountNonExpired = userProfile.getAccountNonExpired();
		this.accountNonLocked = userProfile.getAccountNonLocked();
		this.credentialsNonExpired = userProfile.getCredentialsNonExpired();
		
	}

	public UserProfile getUserProfile(Role r) {
		UserProfile  userProfile = new UserProfile(r,username,password,email);
		userProfile.setAccountNonExpired(accountNonExpired);
		userProfile.setAccountNonLocked(accountNonLocked);
		userProfile.setCredentialsNonExpired(credentialsNonExpired);
		userProfile.setEnabled(enabled);
		
		return userProfile;
	}

}
