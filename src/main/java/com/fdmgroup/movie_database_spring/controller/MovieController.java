package com.fdmgroup.movie_database_spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.movie_database_spring.model.Movie;
import com.fdmgroup.movie_database_spring.service.MovieService;

@Controller
public class MovieController {

	private static final Logger LOGGER = LogManager.getLogger(MovieController.class);

	@Autowired
	MovieService movieService;

	@GetMapping("/AllMovies")
	public ModelAndView allMovies() {
		LOGGER.info("all movies have been retrieved");
		return new ModelAndView("WEB-INF/allMovies.jsp", "allMovies", movieService.retrieveAll());
	}

	@GetMapping("/AddMovie")
	public String addMovie() {
		return "WEB-INF/addMovie.jsp";
	}

	@PostMapping("/AddMovieSubmit")
	public ModelAndView addMovieSubmit(Movie movie, ModelAndView modelAndView) {
		modelAndView.setViewName("WEB-INF/allMovies.jsp");
		if (movieService.create(movie)) {
			LOGGER.info("The movie {} has been added to the database");
			modelAndView.addObject("message", "Movie " + movie.getName() + " has been added to the database");
			modelAndView.addObject("allMovies", movieService.retrieveAll());
			return modelAndView;
		} else {
			LOGGER.info("The movie is already in the database");
			modelAndView.addObject("message", "Movie " + movie.getName() + " is already in the database");
			modelAndView.addObject("allMovies", movieService.retrieveAll());
			return modelAndView;
		}
	}
	
	@GetMapping("/EditMovie/{movieId}")
	public ModelAndView editMovie(@PathVariable("movieId") Long movieId) {
		return new ModelAndView("../WEB-INF/editMovie.jsp", "movie", movieService.retrieveOne(movieId).get());
	}
	
	@PostMapping("/EditMovieSubmit")
	public ModelAndView editMovieSubmit(Movie movie, ModelAndView modelAndView) {
		modelAndView.setViewName("forward://WEB-INF/allMovies.jsp");
		if (movieService.update(movie)) {
			LOGGER.info("Movie {} has been updated", movie.getName());
			modelAndView.addObject("message", "Movie" + movie.getName() + " has been updated in the database");
			modelAndView.addObject("allMovies", movieService.retrieveAll());
			return modelAndView;
		}
		LOGGER.error("This movie is not in the database");
		modelAndView.addObject("message", "Movie" + movie.getName() + " is not in the database");
		modelAndView.addObject("allMovies", movieService.retrieveAll());
		return modelAndView;
	}

}
