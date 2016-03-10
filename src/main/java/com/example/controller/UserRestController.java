package com.example.controller;
import com.example.entity.User;
import com.example.repository.UserRepository;
//import com.sun.enterprise.module.Repository;

//import scala.annotation.meta.setter;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/users") 
public class UserRestController {
	
	@Autowired 
	 private UserRepository userRepository; 
	 
	 @RequestMapping(method = RequestMethod.GET) 
	 public Collection<User> getUsers() { 
	  return this.userRepository.findAll(); 
	 } 
	 
	 @RequestMapping(value = "/{UserId}", method = RequestMethod.GET) 
	 public User getUser( @PathVariable Long userId) { 
	  return this.userRepository.findOne(userId); 
	 } 
	 
	 @RequestMapping(method = RequestMethod.POST) 
	 public User createUser(@RequestBody User User) { 
	  return this.userRepository.save( 
	    new User(  
	      User.getFirstName(), 
	      User.getLastName(), 
	      User.getEmail(),
	      User.getPhone())
	      ); 
	 } 
	 
	 @RequestMapping(value = "/{UserId}",method = RequestMethod.PUT) 
	 public User patchUser( @PathVariable Long UserId,@RequestBody User User) { 
	    User faad = userRepository.findOne(UserId);
	     
	    if(faad != null)
	    {
	    	faad.setFirstName(User.getFirstName());
	    	faad.setEmail(User.getEmail());
	    	faad.setLastName(User.getLastName());
	    	faad.setPhone(User.getPhone());
	    }
	    this.userRepository.save(faad);
	    return this.userRepository.findOne(UserId);
	    
	    		
	    
	   
	 } 
	 
	 @RequestMapping(value = "/{UserId}", method = RequestMethod.DELETE) 
	 public List<User> deleteUser(@PathVariable Long UserId) { 
		 
	  userRepository.delete(UserId); 
	  return this.userRepository.findAll(); 
	 } 
	 
	
	 
}
