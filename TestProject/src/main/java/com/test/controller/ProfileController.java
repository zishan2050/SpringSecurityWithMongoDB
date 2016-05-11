package com.test.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.db.User;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@RequestMapping(method = RequestMethod.GET)
	public User getProfile(Principal principal){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
}
