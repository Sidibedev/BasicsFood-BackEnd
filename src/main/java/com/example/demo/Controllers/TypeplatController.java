package com.example.demo.Controllers;
/*
 * Author Basics
 * Classe Controller 
 */
import javax.validation.Valid;
import com.example.demo.Models.TypePlat;
import com.example.demo.repositories.TypeplatRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TypeplatController {
	
		
	@Autowired
	TypeplatRepository typeplatRepository;
	
	@GetMapping("/typeplat")
    public List<TypePlat> getAllTypes() { // Function that returns all the typeplats created
        
        return typeplatRepository.findAll();
    }

    @PostMapping("/typeplat")
    public TypePlat createType(@Valid @RequestBody TypePlat type) { // Function that  allow to create new type
        
    	type.set_id(ObjectId.get());
    	typeplatRepository.save(type);
    	return type;
    	
    }
    
    @GetMapping(value="/typeplat/{id}")
    public ResponseEntity<TypePlat> getTypeByID(@PathVariable("id") String id){ // Get specific type
    	return typeplatRepository.findById(id)
    			.map(typeplat -> ResponseEntity.ok().body(typeplat))
    			.orElse(ResponseEntity.notFound().build());
    }
    

    @PutMapping(value="/typeplat/{id}")
    public ResponseEntity<TypePlat> updateType(@PathVariable("id") String id,
                                           @Valid @RequestBody TypePlat typeplat) { // Update type
        return typeplatRepository.findById(id)
                .map(typeplatData -> {
                   typeplatData.setNom(typeplat.getNom());
                   
                   
                   TypePlat updatedtype = typeplatRepository.save(typeplatData);
                    return ResponseEntity.ok().body(updatedtype);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
    @DeleteMapping(value="/typeplat/{id}")
    public ResponseEntity<?> deleteType(@PathVariable("id") String id) { // delete a type
        return typeplatRepository.findById(id)
                .map(typeplat -> {
                	typeplatRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
   
	

}
