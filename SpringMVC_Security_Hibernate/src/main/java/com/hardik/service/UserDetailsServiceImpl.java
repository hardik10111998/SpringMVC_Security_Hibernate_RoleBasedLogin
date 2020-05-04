package com.hardik.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hardik.models.User;
import com.hardik.principal.UserPrincipal;
import com.hardik.repository.UserDetailsDao;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDao;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user= userDao.findByUserName(userName);
		if(user==null) 
			throw new UsernameNotFoundException("404");
		return new UserPrincipal(user);
	}

}
