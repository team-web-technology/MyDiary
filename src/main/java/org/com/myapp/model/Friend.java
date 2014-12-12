package org.com.myapp.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friend")
public class Friend implements Serializable{
	@Id
	@Column(name="UserId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int UserId;

	public int getUserId() {
		return UserId;
	}
	public void setUserId(int id) {
		this.UserId = id;
	}
	@Id
	@Column(name="FriendId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int FriendId;

	public int getFriendId() {
		return FriendId;
	}
	public void setFriendId(int friendId) {
		FriendId = friendId;
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}


