/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Blog Data Service
 */

package com.gcu.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Blog;
import com.gcu.model.User;

public class BlogDataService {

	private DataSource ds;
	private JdbcTemplate jto;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jto = new JdbcTemplate(ds);
	}

	/**
	 * Inserts row into blog table in database
	 * 
	 * @param blog
	 * @param session
	 * @return bool
	 */
	public boolean createBlog(Blog blog, HttpSession session) {

		// get the current date to add to DB
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();

		// get session object
		User u1 = (User) session.getAttribute("user_session");

		String sql = "INSERT INTO BLOG ( title, body, date, user_id) VALUES ( ?, ?, ?, ?)";

		int rowsInserted = jto.update(sql, blog.getTitle(), blog.getBody(), dtf.format(now), u1.getId());

		if (rowsInserted > 0) {
			System.out.println("Blog created successfully BDS");
			return true;
		} else {
			System.out.println("Blog created unsuccessfully BDS");

		}

		return false;

	}

	/**
	 * Select all rows in blog table in database
	 * 
	 * @return List<Blog>
	 */
	public List<Blog> findAll() {

		List<Blog> allBlogs = new ArrayList<Blog>();

		String sql = "SELECT * FROM BLOG";

		// prepare sql statement
		SqlRowSet rs = jto.queryForRowSet(sql);

		while (rs.next()) {

			allBlogs.add(new Blog(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("body"),
					rs.getString("date"), ""));
		}

		return allBlogs;
	}

	/**
	 * Select from blog table using user id
	 * 
	 * @param user
	 * @return Blog
	 */
	public Blog findByUserId(User user) {

		Blog foundBlog = new Blog();

		String sql = "SELECT * FROM BLOG WHERE user_id = ?";

		// prepare sql statement
		SqlRowSet rs = jto.queryForRowSet(sql, user.getId());

		if (rs.first()) {
			System.out.println("BDS Success findBlog");
			foundBlog.setId(rs.getInt("id"));
			foundBlog.setUser_id(rs.getInt("user_id"));
			foundBlog.setTitle(rs.getString("title"));
			foundBlog.setBody(rs.getString("body"));
			foundBlog.setDate(rs.getString("date"));

		} else {
			System.out.println("BDS Fail findBlog");
		}

		return foundBlog;
	}
	
	/**
     * Select all blogs from blog table using user id
     * 
     * @param user
     * @return Blogs
     */
    public List<Blog> findAllByUserId(User user) {

        List<Blog> foundBlogs = new ArrayList<Blog>();

        String sql = "SELECT * FROM BLOG WHERE user_id = ?";

        // prepare sql statement
        SqlRowSet rs = jto.queryForRowSet(sql, user.getId());

        while (rs.next()) {
            foundBlogs.add(new Blog(rs.getInt("id"), rs.getInt("user_id"), rs.getString("title"), rs.getString("body"),rs.getString("date"), ""));

        } 

        return foundBlogs;
    }
	
	/**
	 * Select from blog table using blog id
	 * 
	 * @param int
	 * @return Blog
	 */
	public Blog findById(int id) {

		Blog foundBlog = new Blog();

		String sql = "SELECT * FROM BLOG WHERE id = ?";

		// prepare sql statement
		SqlRowSet rs = jto.queryForRowSet(sql, id);

		if (rs.first()) {
			foundBlog.setId(rs.getInt("id"));
			foundBlog.setUser_id(rs.getInt("user_id"));
			foundBlog.setTitle(rs.getString("title"));
			foundBlog.setBody(rs.getString("body"));
			foundBlog.setDate(rs.getString("date"));

		} else {
			System.out.println("BDS Fail findBlog");
		}
		System.out.println(foundBlog.getId() + "IN BDS FINDBLOG");

		return foundBlog;
	}

	/**
	 * Delete row with owner id from Blog table in database
	 * 
	 * @param blog
	 * @return bool
	 */
	public boolean deleteBlog(Blog blog) {

		// get the id
		int id = blog.getId();

		// SQL statement
		String sql = "DELETE FROM BLOG WHERE ID = ?";

		// execute statement
		int rowDeleted = jto.update(sql, id);

		if (rowDeleted > 0) {
			System.out.println("Blog deleted successfully BDS");
			return true;
		} else {
			System.out.println("Blog deleted unsuccessfully BDS");

		}

		return false;
	}

	/**
	 * Update row with owner id from Blog table in database
	 * 
	 * @param blog
	 * @return bool
	 */
	public boolean updateBlog(Blog blog) {
		System.out.println(blog.getId() + "IN BDS UPDATEBLOG");

		String sql = "UPDATE BLOG SET title = ?, body = ? WHERE ID = ?";

		// execute statement
		int rowUpdated = jto.update(sql, blog.getTitle(), blog.getBody(), blog.getId());

		if (rowUpdated > 0) {
			System.out.println("Blog updated successfully BDS");
			return true;
		} else {
			System.out.println("Blog updated unsuccessfully BDS");

		}
		return false;
	}

}
