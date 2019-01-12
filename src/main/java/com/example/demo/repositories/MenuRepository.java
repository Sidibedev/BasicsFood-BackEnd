/*
 * Author basics
 * Interface for accesing data from our mongodb Database
 */
package com.example.demo.repositories;

import com.example.demo.Models.Menus;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


/*
 * The MongoRepository interface defines methods
 *  for all the CRUD operations on the Document
 *   like finAll(), fineOne(), save(), delete() etc.
 */

@Repository
public interface MenuRepository extends MongoRepository<Menus, String> {
	 
	@Query("{'TypePlat.name' : ?0}")
	 public List<Menus> findByTypePlat(String typePlat);
	
	
}