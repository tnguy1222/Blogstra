/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * User Model
 */

package com.gcu.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;

@Scope(value="session")
public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", password=" + password + "]";
	}

	private int id;

	@NotEmpty(message = "First name cannot be null")
	@Size(min = 2, max = 16, message = "First name must be between 2 and 16 characters")
	private String firstName;

	@NotEmpty(message = "Last name cannot be null")
	@Size(min = 2, max = 16, message = "Last name must be between 2 and 16 characters")
	private String lastName;

	@NotEmpty(message = "Email cannot be null")
	@Size(min = 2, max = 56, message = "Email must be between 2 and 56 characters")
	private String email;

	@NotEmpty(message = "Phone number cannot be null")
	@Size(min = 7, max = 12, message = "Phone number must be between 7 and 12 characters")
	private String phoneNumber;

	@NotEmpty(message = "Username cannot be null")
	@Size(min = 2, max = 16, message = "Username must be between 2 and 16 characters")
	private String username;

	@NotEmpty(message = "Password cannot be null")
	@Size(min = 2, max = 16, message = "Password must be between 2 and 16 characters")
	private String password;

	public User(int id, String firstName, String lastName, String email, String phoneNumber, String username,
			String password) {
		// super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}

	public User() {
		id = 0;
		firstName = "";
		lastName = "";
		email = "";
		phoneNumber = "";
		username = "";
		password = "";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
