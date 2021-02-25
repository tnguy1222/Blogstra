/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Blog Model
 */

package com.gcu.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Blog {

	private int id;
	private int user_id;
	
	@NotEmpty(message = "Title cannot be null")
	@Size(min = 2, max = 256, message = "Title must be between 2 and 256 characters")
	private String title;
	
	@NotEmpty(message = "Body cannot be null")
	@Size(min = 2, max = 65535, message = "Body must be between 2 and 16 characters")
	private String body;
	
	private String date;
	
	private String username;
	
	public Blog()
	{
		id = 0;
		user_id = 0;
		title = "";
		body = "";
		date = "";
		username = "";
	}

	public Blog(int id, int user_id, String title, String body, String date, String username) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
