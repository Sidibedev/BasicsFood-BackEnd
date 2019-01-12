/*
 * Author Basics
 * Classe TypePlat : our typleplat document
 */

package com.example.demo.Models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="typeplat")
public class TypePlat {
	
	@Id
	private ObjectId _id;
	private String nom;
	
	public TypePlat(ObjectId _id , String nom) {
		this._id = _id;
		this.nom = nom;
	}
	public TypePlat() {
		
		super();
	}
	 public String get_id() { return _id.toHexString(); }
	  public void set_id(ObjectId _id) { this._id = _id; }

	public String getNom() {
		return nom;
	}
	
	

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
