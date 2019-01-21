package com.example.demo.Controllers;
/*
 * Author Basics
 * Classe Controller 
 */
import javax.validation.Valid;
import com.example.demo.Models.Users;
import com.example.demo.repositories.UserRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://basics-food.firebaseapp.com", maxAge = 3600)
public class UserController {
	
		
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
    public List<Users> getAllUsers() { // Function that returns all the users created
        
        return userRepository.findAll();
    }
	@PostMapping("/auth/login")
    public Boolean login() { // Function that returns all the users created
        
        return false;
    }
	@CrossOrigin
    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users user) { // Function that  allow to create new user
        
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String hashedPassword = passwordEncoder.encode(user.getPassword());
    	user.setPassword(hashedPassword);
    	user.set_id(ObjectId.get());
    	return userRepository.save(user);
    	
    }
    
    @GetMapping(value="/users/{id}")
    public ResponseEntity<Users> getUserByID(@PathVariable("id") String id){ // Get specific user
    	return userRepository.findById(id)
    			.map(user -> ResponseEntity.ok().body(user))
    			.orElse(ResponseEntity.notFound().build());
    }
    

    @PutMapping(value="/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") String id,
                                           @Valid @RequestBody Users user) { // Update user
        return userRepository.findById(id)
                .map(userData -> {
                   userData.setUsername(user.getUsername());
                   userData.setPassword(user.getPassword());
                   
                   
                   Users updatedUser = userRepository.save(userData);
                    return ResponseEntity.ok().body(updatedUser);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
    @DeleteMapping(value="/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) { // delete a user
        return userRepository.findById(id)
                .map(user -> {
                	userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
   
	

}
