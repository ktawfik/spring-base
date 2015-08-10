package com.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="mobile")
	private String mobile;
	
	
	public String toString(){
		return "User [id: "+userId+", name:" + userName + "]";
	}
	
	public boolean equals(Object o){
		if(! (o instanceof User) || o == null){
			return false;
		}
		
		User u = (User) o;
		return u.getUserId().equals(userId);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
