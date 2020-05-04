package com.hardik.repository;

import java.util.List;

import com.hardik.models.User;

public interface UserDetailsDao {
	
	User findByUserName(String userName);
	void save(User user);
	List<User> findAll();
	User findByUserId(int userId);
	void delete(int userId);
	void update(User user);
}
