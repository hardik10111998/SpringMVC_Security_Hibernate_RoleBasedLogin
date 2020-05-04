package com.hardik.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardik.models.User;
import com.hardik.repository.UserDetailsDao;

@Service
@Transactional
public class UserServcieImpl implements UserService{
	
	@Autowired
	private UserDetailsDao userDao;
	
	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findByUserId(int userId) {
		return userDao.findByUserId(userId);
	}

	public void delete(int userId) {
		userDao.delete(userId);
	}

	public void update(User user) {
		userDao.update(user);
	}
	public void save(User user){
		userDao.save(user);
	}
	public User findByUserName(String userName){
		return  userDao.findByUserName(userName);
		
	}

}
