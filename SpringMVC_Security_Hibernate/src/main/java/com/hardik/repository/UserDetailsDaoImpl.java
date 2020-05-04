package com.hardik.repository;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardik.models.Authorities;
import com.hardik.models.User;


@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private AuthorityDao authDao;
	
	public User findByUserName(String userName)
	{
		 Query query= sessionFactory.getCurrentSession().createQuery("from User u where u.userName= :userName");
		 query.setParameter("userName", userName);
		 User user= (User)query.getSingleResult();
//		 return sessionFactory.getCurrentSession().get(User.class, user.getUserId());
		 return user;
	}
	public void save(User user)
	{
		user.setAuthorities(new HashSet<Authorities>(Arrays.asList(authDao.findByAuthorityName("ROLE_USER"))));
		sessionFactory.getCurrentSession().save(user);
	}
	@SuppressWarnings("deprecation")
	public List<User> findAll() {
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> list= criteria.list();
		return list;		
	}
	
	public User findByUserId(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId",userId));
		List<User> list= criteria.list();
		return list.get(0);		
	}
	
	public void delete(int userId) {
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userId));
		User user= (User)criteria.uniqueResult();
		System.out.println("User Deleted With Id:-"+user.getUserId());
		sessionFactory.getCurrentSession().delete(user);
	}
	public void update(User user) {
		Criteria criteria= sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", user.getUserId()));
		User newUser=(User)criteria.uniqueResult();
	System.out.println(newUser.getUserId());
		newUser.setUserName(user.getUserName());
		newUser.setPassword(user.getPassword());
		newUser.setUserAddress(user.getUserAddress());
		newUser.setUserEmail(user.getUserEmail());
	sessionFactory.getCurrentSession().saveOrUpdate(newUser);
	}

}
