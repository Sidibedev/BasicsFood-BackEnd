/*
 * Author Basics
 * Classe modele utilisateur
 */
package com.example.demo.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users {
	
	public Users() {
		
	}
	@Id
	private ObjectId _id;
	private String username;
	private String password;
	
	public Users(String username , String password) {
		this.username = username;
		this.password = password;
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
	public String get_id() { return _id.toHexString(); }

	public void set_id(ObjectId _id) { this._id = _id; }

}
