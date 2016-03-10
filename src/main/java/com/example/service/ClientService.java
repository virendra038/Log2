package com.example.service;
import com.example.repository.ClientRepository;
import com.example.entity.Client;

import java.util.Arrays; 

import org.springframework.boot.CommandLineRunner; 
import org.springframework.context.annotation.Bean; 

public class ClientService {
	
	@Bean 
	 public CommandLineRunner init(ClientRepository clientRepository) { 
	  return args -> { 
	   clientRepository.deleteAll(); 
	   Arrays.asList("aku,maku".split(",")).forEach(userId -> { 
	     Arrays.asList("Stéphane,Maldini;Dave,Syer;Juergen,Hoeller;Rob,Winch;Mark,Fisher;Arjen,Poutsma".split(";")) 
	      .stream() 
	      .map(name -> name.split(",")) 
	      .map(a -> new Client( 
	        a[0]
	        )) 
	      .forEach(clientRepository::save); 
	    }); 
	  }; 

}
}
