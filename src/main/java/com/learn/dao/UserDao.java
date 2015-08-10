package com.learn.dao;

import java.util.List;

import com.learn.entity.User;

public interface UserDao {

	public User getUser(Integer id);

	public void addUser(User u) ;

	public void deleteUser(User u);

	public List<User> listUsers();
	
}
