package com.fdmgroup.movie_database_spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.movie_database_spring.model.Actor;
import com.fdmgroup.movie_database_spring.service.ActorService;

@Controller
public class ActorController {

	private static final Logger LOGGER = LogManager.getLogger(ActorController.class);

	@Autowired
	ActorService actorService;

	@GetMapping("/AllActors")
	public ModelAndView allActors() {
		LOGGER.info("all actors have been retrieved");
		return new ModelAndView("WEB-INF/allActors.jsp", "allActors", actorService.retrieveAll());
	}

	@GetMapping("/AddActor")
	public String addActor() {
		return "WEB-INF/addActor.jsp";
	}

	@PostMapping("/AddActorSubmit")
	public ModelAndView addActorSubmit(Actor actor, ModelAndView modelAndView) {
		modelAndView.setViewName("WEB-INF/allActors.jsp");
		if (actorService.create(actor)) {
			LOGGER.info("The actor {} has been added to the database");
			modelAndView.addObject("message", "Actor " + actor.getFirstname() + " has been added to the database");
			modelAndView.addObject("allActors", actorService.retrieveAll());
			return modelAndView;
		} else {
			LOGGER.info("The actor is already in the database");
			modelAndView.addObject("message", "Actor " + actor.getFirstname() + " is already in the database");
			modelAndView.addObject("allActors", actorService.retrieveAll());
			return modelAndView;
		}
	}
	
	@GetMapping("/EditActor/{actorId}")
	public ModelAndView editActor(@PathVariable("actorId") Long actorId) {
		return new ModelAndView("../WEB-INF/editActor.jsp", "actor", actorService.retrieveOne(actorId).get());
	}
	
	@PostMapping("/EditActorSubmit")
	public ModelAndView editActorSubmit(Actor actor, ModelAndView modelAndView) {
		modelAndView.setViewName("forward://WEB-INF/allActors.jsp");
		if (actorService.update(actor)) {
			LOGGER.info("Actor {} has been updated", actor.getFirstname());
			modelAndView.addObject("message", "Actor" + actor.getFirstname() + " has been updated in the database");
			modelAndView.addObject("allActors", actorService.retrieveAll());
			return modelAndView;
		}
		LOGGER.error("This actor is not in the database");
		modelAndView.addObject("message", "Actor" + actor.getFirstname() + " is not in the database");
		modelAndView.addObject("allActors", actorService.retrieveAll());
		return modelAndView;
	}
	
	@PostMapping(value = "/EditActorSubmit", params = {"Delete=Delete"})
	public ModelAndView editActorSubmit(Actor actor, ModelAndView modelAndView, Long actorId) {
		if (actorService.delete(actor)) {
			modelAndView.addObject("message", "Actor " + actor.getFirstname() + " has been deleted");
			modelAndView.addObject("allActors", actorService.retrieveAll());
			modelAndView.setViewName("forward://WEB-INF/allActors.jsp");
			return modelAndView;
		}
		modelAndView.addObject("message", "Actor " + actor.getFirstname() + " still stars in movies in the database");
		modelAndView.addObject("allActors", actorService.retrieveAll());
		modelAndView.setViewName("forward://WEB-INF/allActors.jsp");
		return modelAndView;
	}

}
