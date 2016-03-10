package com.example.service;
import com.example.repository.UserRepository;
import com.example.entity.User;

import java.util.Arrays; 

import org.springframework.boot.CommandLineRunner; 
import org.springframework.context.annotation.Bean; 

public class UserService {
	
	@Bean 
	 public CommandLineRunner init(UserRepository userRepository) { 
	  return args -> { 
	   userRepository.deleteAll(); 
	   Arrays.asList("pwebb,jlong".split(",")).forEach(userId -> { 
	     Arrays.asList("Stéphane,Maldini;Dave,Syer;Juergen,Hoeller;Rob,Winch;Mark,Fisher;Arjen,Poutsma".split(";")) 
	      .stream() 
	      .map(name -> name.split(",")) 
	      .map(firstLastName -> new User( 
	        firstLastName[0], 
	        firstLastName[1], 
	        firstLastName[2],
	        firstLastName[3]
	        )) 
	      .forEach(userRepository::save); 
	    }); 
	  }; 

}
}
