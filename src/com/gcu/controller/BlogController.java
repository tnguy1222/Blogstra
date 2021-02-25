/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Blog Controller
 */

package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.BlogBusinessService;
import com.gcu.business.UserBusinessService;
import com.gcu.model.Blog;
import com.gcu.model.User;

@Controller
@RequestMapping("")
public class BlogController {

	// inject business layer
	BlogBusinessService bbs;
	UserBusinessService ubs;

	/**
	 * Route blog page and pass all blogs to the page
	 * 
	 * @return
	 */
	@RequestMapping(path = "/blogs", method = RequestMethod.GET)
	public ModelAndView mapBlogPage() {

		return returnBlogs();
	}

	/**
	 * Route to blog creation page
	 * 
	 * @return
	 */
	@RequestMapping(path = "/addBlog", method = RequestMethod.GET)
	public ModelAndView mapAddBlogPage() {

		return new ModelAndView("addBlog", "blog", new Blog());
	}

	/**
	 * Validation and handling for blog creation
	 * 
	 * @param session
	 * @param blog
	 * @param result
	 * @return
	 */
	@RequestMapping(path = "/createblog", method = RequestMethod.POST)
	public ModelAndView createBlog(HttpSession session, @Valid @ModelAttribute("blog") Blog blog,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("addBlog", "blog", blog);
		}

		if (bbs.createBlog(blog, session) != null) {
			return returnBlogs();
		} else {
			return new ModelAndView("failPage", "error", "Failed to create blog");
		}

	}

	/**
	 * Finds blog post with id
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/findBlog/{id}", method = RequestMethod.GET)
	public ModelAndView findBlog(@PathVariable int id) {

		Blog foundBlog = bbs.findById(id);

		return new ModelAndView("blogsUpdateForm", "blog", foundBlog);
	}
	
	/**
	 * Updates blog in database
	 * @param blog
	 * @param result
	 * @return
	 */
	@RequestMapping(path = "/updateBlog", method = RequestMethod.POST)
	public ModelAndView updateBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult result) {

		if (result.hasErrors()) {

			return new ModelAndView("blogsUpdateForm", "blog", blog);
		}

		if (bbs.updateBlog(blog)) {
			return returnBlogs();
		} else {
			return new ModelAndView("failPage", "error", "Failed to update blog");
		}

	}

	/**
	 * Directs user to deletion confirmation page
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/blogsConfirmDelete/{id}", method = RequestMethod.GET)
	public ModelAndView mapDeleteBlogPage(@PathVariable int id) {

		Blog foundBlog = bbs.findById(id);

		return new ModelAndView("blogsConfirmDelete", "blog", foundBlog);
	}

	/**
	 * Deletes blog in database
	 * @param blog
	 * @return
	 */
	@RequestMapping(path = "/deleteBlog", method = RequestMethod.POST)
	public ModelAndView deleteBlog(@ModelAttribute("blog") Blog blog) {

		if (bbs.deleteBlog(blog)) {
			return returnBlogs();
		} else {
			return new ModelAndView("failPage", "error", "Failed to delete blog");
		}

	}
	
	/**
     * Finds all blog post belongs to user_id
     * @param id
     * @return
     */
    @RequestMapping(path = "/findUserBlogs", method = RequestMethod.GET)
    public ModelAndView findUserBlogs(HttpSession session) {

    	User u1 = (User) session.getAttribute("user_session");
    	
        List<Blog> foundBlogs = bbs.findAllByUserId(u1);
        

        return new ModelAndView("blogsByUser", "blogs", foundBlogs);

    }

	/**
	 * Repeat code used to find all blogs and return them to the blogs page
	 * 
	 * @return
	 */
	public ModelAndView returnBlogs() {
		List<Blog> foundBlogs = bbs.findAll();
		for (int i = 0; i < foundBlogs.size(); i++) {

			User owner = ubs.findByUserID(foundBlogs.get(i).getUser_id());

			foundBlogs.get(i).setUsername(owner.getFirstName() + " " + owner.getLastName());
		}

			return new ModelAndView("blogs", "blogs", foundBlogs);
	}

	public void setBlogService(BlogBusinessService service) {
		this.bbs = service;
	}

	public void setUserService(UserBusinessService service) {
		this.ubs = service;
	}
}
