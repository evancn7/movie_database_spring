package com.fdmgroup.movie_database_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.movie_database_spring.model.Director;
import com.fdmgroup.movie_database_spring.repository.DirectorDao;

@Service
public class DirectorService {

	@Autowired
	private DirectorDao directorDao;

	public DirectorService(DirectorDao directorDao) {
		this.directorDao = directorDao;
	}

	public boolean create(Director director) {
		String email = director.getEmail();
		if (directorDao.getByEmail(email).isEmpty()) {
			directorDao.save(director);
			return true;
		}
		return false;
	}

	public Optional<Director> retrieveOne(long directorId) {
		if (directorId != 0) {
			return directorDao.findById(directorId);
		} else
			return null;
	}

	public List<Director> retrieveAll() {
		return directorDao.findAll();
	}

	public boolean update(Director director) {
		if (retrieveOne(director.getDirectorId()).isPresent()) {
			directorDao.save(director);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Director director) {
		long directorId = director.getDirectorId();
		if (directorDao.checkDirectorHasNoMovies(directorId).isEmpty()) {
			directorDao.delete(director);
			return true;
		} else {
			return false;
		}
	}
	

}
