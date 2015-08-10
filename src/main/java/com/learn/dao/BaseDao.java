package com.learn.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao {

	
	public Object save(Object o);
	
	public List getAll(String entity);
	
	public void saveAll(List entities);
	
	public void delete(Object o);
	
	public void update(Object o);
	
	public Object get(Class c, Integer id);
	
	public Session getSession();
}
