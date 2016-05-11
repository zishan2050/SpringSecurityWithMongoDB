package com.test.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.db.User;

public interface UserDao extends MongoRepository<User, String>{

	public User findByUsername(String username);
	
}
