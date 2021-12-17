package com.fdmgroup.movie_database_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.movie_database_spring.model.Movie;
import com.fdmgroup.movie_database_spring.repository.MovieDao;

@Service
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;

	public MovieService(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	public boolean create(Movie movie) {
		String name = movie.getName();
		if (movieDao.getByName(name).isEmpty()) {
			movieDao.save(movie);
			return true;
		}
		return false;
	}

	public Optional<Movie> retrieveOne(long movieId) {
		if (movieId != 0) {
			return movieDao.findById(movieId);	
		}
		return null;
	}

	public List<Movie> retrieveAll() {
		return movieDao.findAll();
	}

	public boolean update(Movie movie) {
		if (retrieveOne(movie.getMovieId()).isPresent()) {
			movieDao.save(movie);
			return true;
		} else {
			return false;
		}
	}

}
