package com.fdmgroup.movie_database_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.movie_database_spring.model.User;
import com.fdmgroup.movie_database_spring.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public User getByUsernameAndPassword(String username, String password) {
		return userDao.getByUsernameAndPassword(username, password);
	}

}
