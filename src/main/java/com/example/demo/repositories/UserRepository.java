/*
 * Author basics
 * Interface for accesing data from our mongodb Database
 */
package com.example.demo.repositories;

import com.example.demo.Models.TypePlat;
import com.example.demo.Models.Users;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*
 * The MongoRepository interface defines methods
 *  for all the CRUD operations on the Document
 *   like finAll(), fineOne(), save(), delete() etc.
 */

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
	
	Users findByUsername(String username);
	Users findBy_id(ObjectId _id);
	
	
}