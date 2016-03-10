package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Client;
import com.example.repository.ClientRepository;

@RestController
@RequestMapping("/clients") 
public class ClientRestController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	 @RequestMapping(method = RequestMethod.GET) 
	 public List<Client> getClients() { 
		  return this.clientRepository.findAll(); 
		 } 
	 
	 @RequestMapping(value = "/{ClientId}", method = RequestMethod.GET) 
	 public List<Client> getUser(@PathVariable String ClientId) { 
	  return this.clientRepository.findByClientId(ClientId); 
	 } 
	 
	 @RequestMapping(method = RequestMethod.POST) 
	 public Client createClient( @RequestBody Client Client) { 
	  return this.clientRepository.save( 
	    new Client( 
	      Client.getClientName())
	      ); 
	 }
	 
	 @RequestMapping(value = "/{ClientId}", method = RequestMethod.DELETE) 
	 public List<Client> deleteClient(@PathVariable Long ClientId) { 
		 
	  clientRepository.delete(ClientId); 
	  return this.clientRepository.findAll(); 
	 } 

}
