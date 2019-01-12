/*
 * Author basics
 * Interface for accesing data from our mongodb Database
 */
package com.example.demo.repositories;

import com.example.demo.Models.TypePlat;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*
 * The MongoRepository interface defines methods
 *  for all the CRUD operations on the Document
 *   like finAll(), fineOne(), save(), delete() etc.
 */

@Repository
public interface TypeplatRepository extends MongoRepository<TypePlat, String> {
	
			
	TypePlat findBy_id(ObjectId _id);
	
	
}