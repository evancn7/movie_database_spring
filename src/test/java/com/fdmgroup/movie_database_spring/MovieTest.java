package com.fdmgroup.movie_database_spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.fdmgroup.movie_database_spring.model.Actor;
import com.fdmgroup.movie_database_spring.model.Director;
import com.fdmgroup.movie_database_spring.model.Genre;
import com.fdmgroup.movie_database_spring.model.Movie;
import com.fdmgroup.movie_database_spring.service.ActorService;
import com.fdmgroup.movie_database_spring.service.DirectorService;
import com.fdmgroup.movie_database_spring.service.MovieService;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class MovieTest {
	
	@Autowired
	private ActorService actorService;
	
	private List<Actor> cast;
	
	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private MovieService movieService;


	@Test
	void test_ThatAMovieCanBePersisted() {
		Actor actor1 = actorService.retrieveOne(1).get();
		Actor actor2 = actorService.retrieveOne(2).get();
		cast = new ArrayList<>(Arrays.asList(actor1, actor2));
		Director director = directorService.retrieveOne(4).get();
		Movie movie = new Movie("Once Upon a Time in Hollywood", director, cast, 161, Genre.COMEDY, LocalDate.of(2019, 07, 26));
		boolean created = movieService.create(movie);
		assertTrue(created);
	}
	
	@Test
	void test_ThatAMovieCanBeRetrievedWithTheId() {
		Movie movie = movieService.retrieveOne(1).get();
		assertEquals(1, movie.getMovieId());
	}
	
	@Test
	void test_ThatAListOfMoviesCanBeRetrieved() {
		List<Movie> allMovies = movieService.retrieveAll();
		assertFalse(allMovies.isEmpty());
	}
	
	@Test
	void test_ThatAMovieCanBeUpdated() {
		Movie movieToUpdate = movieService.retrieveOne(1).get();
		String titleBeforeUpdate = movieToUpdate.getName();
		movieToUpdate.setName("Pulp Fiction");
		movieService.update(movieToUpdate);
		Movie updatedMovie = movieService.retrieveOne(1).get();
		String titleAfterUpdate = updatedMovie.getName();
		assertNotEquals(titleBeforeUpdate, titleAfterUpdate);
	}

}
