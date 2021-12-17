package com.fdmgroup.movie_database_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.movie_database_spring.model.Director;

public interface DirectorDao extends JpaRepository<Director, Long> {

	List<Director> getByEmail(String email);

	@Query(value = "Select directorId from movie m where m.directorId = :directorId", nativeQuery = true)
	List<Integer> checkDirectorHasNoMovies(@Param("directorId") long directorId);

}
