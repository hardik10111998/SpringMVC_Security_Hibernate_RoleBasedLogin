package com.hardik.repository;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hardik.models.Authorities;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Authorities findByAuthorityName(String authority) {
			Query query= sessionFactory.getCurrentSession().createQuery("from Authorities a where a.authority= :authority");
			query.setParameter("authority", authority);
			Authorities userAuthority= (Authorities)query.getSingleResult();
			return userAuthority;
		
	}

}
