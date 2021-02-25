/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * User Controller
 */

package com.gcu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessService;
import com.gcu.model.Credential;
import com.gcu.model.User;

@Controller
@RequestMapping("")
public class UserController {
	
	//inject business layer
	UserBusinessService ubs;

	/**
	 * Mapping to home page
	 * @return
	 */
	@RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
	public String mapHomePage() {
		
		return "home";
	}

	/**
	 * Invalidate session to logout
	 * @param session
	 * @return
	 */
	@RequestMapping(path = {"/logout"}, method = RequestMethod.GET)
	public String mapLogOut(HttpSession session) {
		session.invalidate();
		
		return "home";
	}
	
	/**
	 * Mapping to login page
	 * @return
	 */
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView mapLoginPage() {

		return new ModelAndView("login", "user", new Credential());
	}

	/**
	 * Mapping to register page
	 * @return
	 */
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public ModelAndView mapRegisterPage() {

		return new ModelAndView("register", "user", new User());
	}

	/**
	 * Calls business service to register new user. Handles validation
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(path = "/registeruser", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		}
		if(ubs.create(user))
		{
			return new ModelAndView("login", "user", new User());
		}
		else
		{
			return new ModelAndView("failPage", "error", "Failed to register user");
		}
	}

	/**
	 * Calls business service to find credentials. Handles validation
	 * @param credential
	 * @param result
	 * @return
	 */
	@RequestMapping(path = "/loginuser", method = RequestMethod.POST)
	public ModelAndView login(HttpSession session, @Valid @ModelAttribute("user") Credential credential, BindingResult result) {
		if (result.hasErrors()) {
			
			return new ModelAndView("login", "user", credential);
		}
		
		User foundUser = ubs.findUser(credential);
		
		if(foundUser != null)
		{
			session.setAttribute("user_session", foundUser);
			
			return new ModelAndView("home", "", "");
		}
		else
		{
			return new ModelAndView("failPage", "error", "Username or password is incorrect");
		}
		
	}
	
	public void setUserService(UserBusinessService service) {
		this.ubs = service;
	}
}
