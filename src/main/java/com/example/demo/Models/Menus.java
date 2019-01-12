/*
 * Author Basics
 * Classe Menus : our menu document
 */
package com.example.demo.Models;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="menus")
public class Menus {
    @Id
    private ObjectId _id;
    private String plat;
    private TypePlat typePlat;
    private Double prix;
    private String photo;
    private String desc;


    public Menus() {
        super();
    }
    
    public String get_id() { return _id.toHexString(); }
	 
    public void set_id(ObjectId _id) { this._id = _id; }

    public Menus(String plat, TypePlat typeplat , Double prix , String photo , String desc) {
        this.plat = plat ;
        this.typePlat = typeplat;
        this.prix = prix;
        this.photo = photo;
        this.desc = desc;
    }

	

	public String getPlat() {
		return plat;
	}

	public void setPlat(String plat) {
		this.plat = plat;
	}

	public TypePlat getTypePlat() {
		return typePlat;
	}

	public void setTypePlat(TypePlat typeplat) {
		this.typePlat = typeplat;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

   
}