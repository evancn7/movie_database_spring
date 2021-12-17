package com.fdmgroup.movie_database_spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.movie_database_spring.model.Director;
import com.fdmgroup.movie_database_spring.service.DirectorService;

@Controller
public class DirectorController {

	private static final Logger LOGGER = LogManager.getLogger(DirectorController.class);

	@Autowired
	DirectorService directorService;

	@GetMapping("/AllDirectors")
	public ModelAndView allDirectors() {
		LOGGER.info("all directors have been retrieved");
		return new ModelAndView("WEB-INF/allDirectors.jsp", "allDirectors", directorService.retrieveAll());
	}

	@GetMapping("/AddDirector")
	public String addDirector() {
		return "WEB-INF/addDirector.jsp";
	}

	@PostMapping("/AddDirectorSubmit")
	public ModelAndView addDirectorSubmit(Director director, ModelAndView modelAndView) {
		modelAndView.setViewName("WEB-INF/allDirectors.jsp");
		if (directorService.create(director)) {
			LOGGER.info("The director {} has been added to the database");
			modelAndView.addObject("message", "Director " + director.getFirstname() + " has been added to the database");
			modelAndView.addObject("allDirectors", directorService.retrieveAll());
			return modelAndView;
		} else {
			LOGGER.info("The director is already in the database");
			modelAndView.addObject("message", "Director " + director.getFirstname() + " is already in the database");
			modelAndView.addObject("allDirectors", directorService.retrieveAll());
			return modelAndView;
		}
	}
	
	@GetMapping("/EditDirector/{directorId}")
	public ModelAndView editDirector(@PathVariable("directorId") Long directorId) {
		return new ModelAndView("../WEB-INF/editDirector.jsp", "director", directorService.retrieveOne(directorId).get());
	}
	
	@PostMapping("/EditDirectorSubmit")
	public ModelAndView editDirectorSubmit(Director director, ModelAndView modelAndView) {
		modelAndView.setViewName("forward://WEB-INF/allDirectors.jsp");
		if (directorService.update(director)) {
			LOGGER.info("Director {} has been updated", director.getFirstname());
			modelAndView.addObject("message", "Director" + director.getFirstname() + " has been updated in the database");
			modelAndView.addObject("allDirectors", directorService.retrieveAll());
			return modelAndView;
		}
		LOGGER.error("This director is not in the database");
		modelAndView.addObject("message", "Director" + director.getFirstname() + " is not in the database");
		modelAndView.addObject("allDirectors", directorService.retrieveAll());
		return modelAndView;
	}
	
	@PostMapping(value = "/EditDirectorSubmit", params = {"Delete=Delete"})
	public ModelAndView editDirectorSubmit(Director director, ModelAndView modelAndView, Long directorId) {
		if (directorService.delete(director)) {
			modelAndView.addObject("message", "Director " + director.getFirstname() + " has been deleted");
			modelAndView.addObject("allDirectors", directorService.retrieveAll());
			modelAndView.setViewName("forward://WEB-INF/allDirectors.jsp");
			return modelAndView;
		}
		modelAndView.addObject("message", "Director " + director.getFirstname() + " still stars in movies in the database");
		modelAndView.addObject("allDirectors", directorService.retrieveAll());
		modelAndView.setViewName("forward://WEB-INF/allDirectors.jsp");
		return modelAndView;
	}

}
