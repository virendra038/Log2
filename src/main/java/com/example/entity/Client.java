package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.entity.User;

@Entity
public class Client {
	
   @OneToMany()
   private Set<User> users = new HashSet<>();
	
	@Id
	@GeneratedValue
	private Long clientId;
	
	private String clientName;
	

	public Client(String clientName) {
		this.clientName = clientName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientname) {
		this.clientName = clientname;
	}
	
	public Long getClientId() {
		return clientId;
	}
	 public Client() { 
	 } 
	 

}
