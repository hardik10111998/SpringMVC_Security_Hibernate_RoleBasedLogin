package com.hardik.service;

import java.util.List;

import com.hardik.models.User;

public interface UserService {
	
	User findByUserName(String userName);
	void save(User user);
	List<User> findAll();
	User findByUserId(int userId);
	void delete(int userId);
	void update(User user);

}
