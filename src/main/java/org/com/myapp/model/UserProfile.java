package org.com.myapp.model;

// Generated Dec 4, 2014 12:47:13 AM by Hibernate Tools 3.6.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Userprofile generated by hbm2java
 */
@Entity
@Table(name = "userprofile", catalog = "diary_v2", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class UserProfile implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Role role;
	private String username;
	private String password;
	private String email;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;
	private Set<Diary> diaries = new HashSet<Diary>(0);
	private Set<UserProfile> userprofilesForFriendId = new HashSet<UserProfile>(
			0);
	private Set<UserProfile> userprofilesForUserId = new HashSet<UserProfile>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<FriendRequest> friendrequestsForReceiverId = new HashSet<FriendRequest>(
			0);
	private Set<DiaryPermission> diarypermissions = new HashSet<DiaryPermission>(
			0);
	private Set<FriendRequest> friendrequestsForSenderId = new HashSet<FriendRequest>(
			0);
	private Set<Category> categories = new HashSet<Category>(0);

	public UserProfile() {
	}

	public UserProfile(Role role, String username, String password, String email) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public UserProfile(Role role, String username, String password,
			String email, Boolean acountNonExpired, Boolean acountNonLocked,
			Boolean credentialsNonExpired, Boolean enabled, Set<Diary> diaries,
			Set<UserProfile> userprofilesForFriendId,
			Set<UserProfile> userprofilesForUserId, Set<Comment> comments,
			Set<FriendRequest> friendrequestsForReceiverId,
			Set<DiaryPermission> diarypermissions,
			Set<FriendRequest> friendrequestsForSenderId,
			Set<Category> categories) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.email = email;
		this.accountNonExpired = acountNonExpired;
		this.accountNonLocked = acountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.diaries = diaries;
		this.userprofilesForFriendId = userprofilesForFriendId;
		this.userprofilesForUserId = userprofilesForUserId;
		this.comments = comments;
		this.friendrequestsForReceiverId = friendrequestsForReceiverId;
		this.diarypermissions = diarypermissions;
		this.friendrequestsForSenderId = friendrequestsForSenderId;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdRole", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "Username", nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "AccountNonExpired")
	public Boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(Boolean acountNonExpired) {
		this.accountNonExpired = acountNonExpired;
	}

	@Column(name = "AccountNonLocked")
	public Boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(Boolean acountNonLocked) {
		this.accountNonLocked = acountNonLocked;
	}

	@Column(name = "CredentialsNonExpired")
	public Boolean getCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Column(name = "Enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofile")
	public Set<Diary> getDiaries() {
		return this.diaries;
	}

	public void setDiaries(Set<Diary> diaries) {
		this.diaries = diaries;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "friend", catalog = "diary_v2", joinColumns = { @JoinColumn(name = "UserId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "FriendId", nullable = false, updatable = false) })
	public Set<UserProfile> getUserprofilesForFriendId() {
		return this.userprofilesForFriendId;
	}

	public void setUserprofilesForFriendId(
			Set<UserProfile> userprofilesForFriendId) {
		this.userprofilesForFriendId = userprofilesForFriendId;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "friend", catalog = "diary_v2", joinColumns = { @JoinColumn(name = "FriendId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "UserId", nullable = false, updatable = false) })
	public Set<UserProfile> getUserprofilesForUserId() {
		return this.userprofilesForUserId;
	}

	public void setUserprofilesForUserId(Set<UserProfile> userprofilesForUserId) {
		this.userprofilesForUserId = userprofilesForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofile")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofileByReceiverId")
	public Set<FriendRequest> getFriendrequestsForReceiverId() {
		return this.friendrequestsForReceiverId;
	}

	public void setFriendrequestsForReceiverId(
			Set<FriendRequest> friendrequestsForReceiverId) {
		this.friendrequestsForReceiverId = friendrequestsForReceiverId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofile")
	public Set<DiaryPermission> getDiarypermissions() {
		return this.diarypermissions;
	}

	public void setDiarypermissions(Set<DiaryPermission> diarypermissions) {
		this.diarypermissions = diarypermissions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofileBySenderId")
	public Set<FriendRequest> getFriendrequestsForSenderId() {
		return this.friendrequestsForSenderId;
	}

	public void setFriendrequestsForSenderId(
			Set<FriendRequest> friendrequestsForSenderId) {
		this.friendrequestsForSenderId = friendrequestsForSenderId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userprofile")
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

}
