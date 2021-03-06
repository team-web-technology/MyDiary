package org.com.myapp.model;

// Generated Dec 4, 2014 12:47:13 AM by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "diary_v2")
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idauthority;
	private String name;
	private Set<UserProfile> userprofiles = new HashSet<UserProfile>(0);

	public Role() {
	}

	public Role(int idauthority, String role) {
		this.idauthority = idauthority;
		this.name = role;
	}

	public Role(int idauthority, String role, Set<UserProfile> userprofiles) {
		this.idauthority = idauthority;
		this.name = role;
		this.userprofiles = userprofiles;
	}

	@Id
	@Column(name = "idauthority", unique = true, nullable = false)
	public int getIdauthority() {
		return this.idauthority;
	}

	public void setIdauthority(int idauthority) {
		this.idauthority = idauthority;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String role) {
		this.name = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserProfile> getUserprofiles() {
		return this.userprofiles;
	}

	public void setUserprofiles(Set<UserProfile> userprofiles) {
		this.userprofiles = userprofiles;
	}

}
