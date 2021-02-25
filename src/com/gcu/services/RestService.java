/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Rest Services
 */

package com.gcu.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.BlogBusinessService;
import com.gcu.business.UserBusinessService;
import com.gcu.model.Blog;
import com.gcu.model.User;

@RestController()
@RequestMapping("/service")
public class RestService {

	BlogBusinessService bbs;
	UserBusinessService ubs;
	
	@GetMapping("/user/{user_id}")
	public User getUser(@PathVariable int user_id)
	{
		return ubs.findByUserID(user_id);
	}
	
	@GetMapping("/blog/{id}")
	public Blog getBlog(@PathVariable int id)
	{
		return bbs.findById(id);
	}
	
	public void setBlogService(BlogBusinessService service) {
		this.bbs = service;
	}

	public void setUserService(UserBusinessService service) {
		this.ubs = service;
	}
}
