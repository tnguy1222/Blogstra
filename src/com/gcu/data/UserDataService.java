/*
 * Adam Bender & Jim Nguyen
 * CST 341 CLC Project Milestone 8
 * 12/20/2020
 * User Data Service
 */

package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Credential;
import com.gcu.model.User;

public class UserDataService {

	private DataSource ds;
	private JdbcTemplate jto;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jto = new JdbcTemplate(ds);
	}

	/**
	 * Insert new row in user table
	 * 
	 * @param user
	 * @return bool
	 */
	public boolean createUser(User user) {

		String sql = "INSERT INTO USER (firstName, lastName, email, phoneNumber, username, password) VALUES (?, ?, ?, ?, ?, ?)";

		int rowsInserted = jto.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getPhoneNumber(), user.getUsername(), user.getPassword());
		if (rowsInserted > 0) {
			System.out.println("User created successfully UDS");
			return true;
		} else {
			System.out.println("User created unsuccessfully UDS");

		}

		return false;
	}

	/**
	 * Find row in user table
	 * 
	 * @param credential
	 * @return User
	 */
	public User findUser(Credential credential) {

		User foundUser = new User();
		String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";

		SqlRowSet rs = jto.queryForRowSet(sql, credential.getUsername(), credential.getPassword());

		if (rs.first()) {
			System.out.println("UDS Success findUser");
			foundUser.setId(rs.getInt("id"));
			foundUser.setFirstName(rs.getString("firstname"));
			foundUser.setLastName(rs.getString("lastname"));
			foundUser.setEmail(rs.getString("email"));
			foundUser.setPhoneNumber(rs.getString("phonenumber"));
			foundUser.setUsername(rs.getString("username"));
			foundUser.setPassword(rs.getString("password"));
			
			return foundUser;
		} else {
			System.out.println("UDS Fail findUser");
		}

		return null;
	}

	/**
	 * Find user in database using id
	 * 
	 * @param user_id
	 * @return User
	 */
	public User findByUserID(int user_id) {

		User foundUser = new User();

		String sql = "SELECT * FROM USER WHERE ID = ?";

		SqlRowSet rs = jto.queryForRowSet(sql, user_id);
		// prepare sql statement

		if (rs.first()) {
			foundUser.setId(rs.getInt("id"));
			foundUser.setFirstName(rs.getString("firstname"));
			foundUser.setLastName(rs.getString("lastname"));
			foundUser.setEmail(rs.getString("email"));
			foundUser.setPhoneNumber(rs.getString("phonenumber"));
			foundUser.setUsername(rs.getString("username"));
			foundUser.setPassword(rs.getString("password"));

		} else {
			System.out.println("UDS Fail findByUserID");
		}

		return foundUser;
	}
}
