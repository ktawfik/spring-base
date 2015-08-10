package com.learn.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.entity.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User getUser(Integer id) {
		return (User) get(User.class, id);
	}
	
	@Override
	public List<User> listUsers() {
		return getAll("User");
	}

	@Override
	public void addUser(User u) {
		save(u);
	}

	@Override
	public void deleteUser(User u) {
		delete(u);
		
	}

}
