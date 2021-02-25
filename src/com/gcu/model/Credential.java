/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * Credential Model
 */

package com.gcu.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Credential {

	@NotEmpty(message = "Username cannot be null")
	@Size(min = 2, max = 16, message = "Username must be between 2 and 16 characters")
	private String username;

	@NotEmpty(message = "Password cannot be null")
	@Size(min = 2, max = 16, message = "Password must be between 2 and 16 characters")
	private String password;

	public Credential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Credential() {
		username = "";
		password = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
