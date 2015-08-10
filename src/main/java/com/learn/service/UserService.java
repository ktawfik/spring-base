package com.learn.service;

import java.util.List;

import com.learn.entity.User;

public interface UserService {

	public User getUser(Integer id);
	
	public void deleteUser(Integer id);
	
	public List<User> listUsers();
	
	public void addUser(User u);
	
}
