/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * User Business Service
 */

package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UserDataService;
import com.gcu.model.Credential;
import com.gcu.model.User;

public class UserBusinessService {

	//inject
	UserDataService uds;
	
	/**
	 * Calls data service to create new user in the user table in database
	 * @param user
	 * @return User
	 */
	public boolean create(User user) {

		boolean flag = uds.createUser(user);
		if (flag) {
			System.out.println("User created successfully UBS!");
			return true;
		}
		System.out.println("User created unsuccessfully UBS");
		return false;
	}

	/**
	 * Calls data service to find row in the user table in database
	 * @param credential
	 * @return User
	 */
	public User findUser(Credential credential) {

		User flag = uds.findUser(credential);
		
		return flag;
	}
	
	/**
	 * Calls data service to find user with user_id in the user table in database
	 * @param user
	 * @return User
	 */
	public User findByUserID(int user_id) {
		
		User flag = uds.findByUserID(user_id);
		return flag;
	}

	@Autowired
	public void setUserDataService(UserDataService uds) {
		this.uds = uds;
	}
}
