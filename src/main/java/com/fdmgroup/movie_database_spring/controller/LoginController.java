package com.fdmgroup.movie_database_spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.movie_database_spring.model.User;
import com.fdmgroup.movie_database_spring.service.UserService;

@Controller
public class LoginController {
	
	private static final String SESSION_ATTRIBUTE_USER = "user";
	
	@Autowired
	UserService userService;

	@GetMapping("/Login")
	public String login() {
		return "login.jsp";
	}

	@PostMapping("/Login")
	public ModelAndView loginSubmit(User user, ModelAndView modelAndView, HttpSession httpSession) {
		User userFromDB = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (userFromDB == null) {
			modelAndView.addObject("message", "Uh oh, looks like you aren't registered yet!");
			modelAndView.setViewName("bad_login.jsp");
			return modelAndView;
		}
		httpSession.setAttribute(SESSION_ATTRIBUTE_USER, userFromDB);
		modelAndView.addObject("name", userFromDB.getUsername());
		modelAndView.setViewName("WEB-INF/menu.jsp");
		return modelAndView;
	}

}
