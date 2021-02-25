/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Blog Business Service
 */

package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.BlogDataService;
import com.gcu.model.Blog;
import com.gcu.model.User;

public class BlogBusinessService {

	// inject
	BlogDataService bds;

	/**
	 * Calls data service to create a blog post
	 * 
	 * @param blog
	 * @param session
	 * @return Blog
	 */
	public Blog createBlog(Blog blog, HttpSession session) {

		// return results from data layer
		boolean flag = bds.createBlog(blog, session);

		if (flag) {
			System.out.println("Blog created successfully BBS");

			return blog;
		}
		System.out.println("Blog created unsuccessfully BBS");

		return null;

	}

	/**
	 * Get all blogs in database
	 * 
	 * @return List<Blog>
	 */
	public List<Blog> findAll() {

		// call data service
		List<Blog> foundBlogs = new ArrayList<Blog>();
		foundBlogs = bds.findAll();

		// return arraylist of blog objects
		if (foundBlogs != null) {
			System.out.println("All blogs found successfully, BBS findAll");
			return foundBlogs;
		}
		System.out.println("All blogs found unsuccessfully, BBS findAll");
		return null;
	}

	/**
	 * Find a blog using the user id
	 * 
	 * @param user
	 * @return Blog
	 */
	public Blog findByUserId(User user) {

		// call data service
		Blog blog = bds.findByUserId(user);

		// return found blog
		if (blog != null) {
			System.out.println("Blog found successfully, BBS findByUserId");
			return blog;
		}
		System.out.println("Blog found unsuccessfully, BBS findByUserId");
		return null;
	}
	
	/**
     * Find all blogs using the user id
     * 
     * @param user
     * @return Blog
     */
    public List<Blog> findAllByUserId(User user) {

        // call data service
        List<Blog> foundBlogs = bds.findAllByUserId(user);

        // return found blog
        if (foundBlogs != null) {
            System.out.println("Blog found successfully, BBS findAllByUserId");
            return foundBlogs;
        }
        System.out.println("Blog found unsuccessfully, BBS findAllByUserId");
        return null;
    }
	
	/**
	 * Find a blog using the blog id
	 * 
	 * @param user
	 * @return Blog
	 */
	public Blog findById(int id) {

		// call data service
		Blog blog = bds.findById(id);

		// return found blog
		if (blog != null) {
			System.out.println("Blog found successfully, BBS findById");
			return blog;
		}
		System.out.println("Blog found unsuccessfully, BBS findById");
		return null;
	}

	/**
	 * Delete blog in database
	 * @param blog
	 * @return bool
	 */
	public boolean deleteBlog(Blog blog) {

		boolean flag = bds.deleteBlog(blog);

		if (flag) {
			System.out.println("Blog deleted successfully BBS");

			return true;
		}
		System.out.println("Blog deleted unsuccessfully BBS");

		return false;
	}

	/**
	 * Update blog in database
	 * @param blog
	 * @return bool
	 */
	public boolean updateBlog(Blog blog) {

		boolean flag = bds.updateBlog(blog);

		if (flag) {
			System.out.println("Blog updated successfully BBS");

			return true;
		}
		System.out.println("Blog updated unsuccessfully BBS");

		return false;
	}

	@Autowired
	public void setBlogDataService(BlogDataService bds) {
		this.bds = bds;
	}

}