package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.dao.UserDao;
import com.learn.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	public void deleteUser(Integer id) {
		User u = getUser(id);
		userDao.deleteUser(u);
	}

	@Override
	public List<User> listUsers() {
		return userDao.listUsers();
	}

	@Override
	public void addUser(User u) {
		userDao.addUser(u);
		
	}

}
