package org.com.myapp.form;

import java.util.Collection;

import org.com.myapp.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class User extends UserProfile implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return AuthorityUtils.createAuthorityList(this.getRole().getRole()
				.toUpperCase());
	}

	@Override
	public boolean isAccountNonExpired() {

		return this.getAcountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {

		return this.getAcountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return this.getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {

		return this.getEnabled();
	}

	public void setDetails(UserProfile userProfile) {
		this.setId(userProfile.getId());
		this.setUsername(userProfile.getUsername());
		this.setPassword(userProfile.getPassword());
		this.setEmail(userProfile.getEmail());
		this.setEnabled(userProfile.getEnabled());
		this.setAcountNonExpired(userProfile.getAcountNonExpired());
		this.setAcountNonLocked(userProfile.getAcountNonLocked());
		this.setCredentialsNonExpired(userProfile.getCredentialsNonExpired());
	}

	public UserProfile getUserProfile() {
		UserProfile u = new UserProfile(getRole(), getUsername(),
				getPassword(), getEmail());
		u.setEnabled(getEnabled());
		u.setAcountNonExpired(getAcountNonExpired());
		u.setAcountNonLocked(getAcountNonLocked());
		u.setCredentialsNonExpired(getCredentialsNonExpired());
		return u;
	}
}
