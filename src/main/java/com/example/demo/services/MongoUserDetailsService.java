package com.example.demo.services;

import com.example.demo.Models.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
@Component
public class MongoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	 @Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Users user = repository.findByUsername(username);

	    if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }

	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

	    return new User(user.getUsername(), user.getPassword(), authorities);
	  }
	
}
