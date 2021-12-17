package com.fdmgroup.movie_database_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.movie_database_spring.model.Movie;

public interface MovieDao extends JpaRepository<Movie, Long> {

	List<Movie> getByName(String movie);

}
