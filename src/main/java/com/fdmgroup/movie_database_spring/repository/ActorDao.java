package com.fdmgroup.movie_database_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.movie_database_spring.model.Actor;

public interface ActorDao extends JpaRepository<Actor, Long> {

	List<Actor> getByEmail(String email);
	
	@Query(value = "Select actorId from actor a where a.actorId = :actorId and exists (select cast_actorId from movie_cast where cast_actorId = a.actorId)", nativeQuery = true)
	List<Integer> checkActorHasNoMovies(@Param("actorId") long actorId);

}
