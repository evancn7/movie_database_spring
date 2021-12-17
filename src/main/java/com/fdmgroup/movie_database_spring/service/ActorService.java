package com.fdmgroup.movie_database_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.movie_database_spring.model.Actor;
import com.fdmgroup.movie_database_spring.repository.ActorDao;

@Service
public class ActorService {

	@Autowired
	private ActorDao actorDao;

	public ActorService(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

	public boolean create(Actor actor) {
		String email = actor.getEmail();
		if (actorDao.getByEmail(email).isEmpty()) {
			actorDao.save(actor);
			return true;
		}
		return false;
	}

	public Optional<Actor> retrieveOne(long actorId) {
		if (actorId != 0) {
			return actorDao.findById(actorId);
		} else
			return null;
	}

	public List<Actor> retrieveAll() {
		return actorDao.findAll();
	}

	public boolean update(Actor actor) {
		if (retrieveOne(actor.getActorId()).isPresent()) {
			actorDao.save(actor);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Actor actor) {
		long actorId = actor.getActorId();
		if (actorDao.checkActorHasNoMovies(actorId).isEmpty()) {
			actorDao.delete(actor);
			return true;
		} else {
			return false;
		}
	}

}
