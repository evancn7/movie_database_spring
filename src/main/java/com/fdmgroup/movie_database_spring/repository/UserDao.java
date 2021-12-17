package com.fdmgroup.movie_database_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.movie_database_spring.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User getByUsernameAndPassword(String username, String password);

}
