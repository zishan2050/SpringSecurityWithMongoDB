package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.db.User;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user != null){
			return user;
		}
		throw new UsernameNotFoundException("User Not Found");
	}
	
}
