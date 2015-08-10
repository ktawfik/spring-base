package com.learn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDaoImpl implements BaseDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Object save(Object o) {
		Session s = sessionFactory.getCurrentSession();
//		s.beginTransaction();
		return  getSession().save(o);
//		s.clear();
//		return r;
	}

	@Override
	public List getAll(String entity) {
		Session s = sessionFactory.getCurrentSession();
		Query q = s.createQuery("from " + entity );
		List result = q.list();
		return result;
	}

	@Override
	public Object get(Class c, Integer id) {
		return sessionFactory.getCurrentSession().get(c, id);
	}

	@Override
	public void saveAll(List entities) {
		Session sess = sessionFactory.getCurrentSession();			
		for(Object o : entities){
			sess.save(o);
		}
	}

	@Override
	public void delete(Object o) {
		sessionFactory.getCurrentSession().delete(o);
	}

	@Override
	public void update(Object o) {
		sessionFactory.getCurrentSession().update(o);
	}

	public Session getSession(){
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
		}catch(Exception e){
			session = sessionFactory.openSession();
		}
		return session;
	}

}
