package com.example.entity;
import com.example.entity.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
@Entity
public class User {
	
	@JsonIgnore
	@OneToMany
	private Client client;
	
	 @Id 
	 @GeneratedValue 
	 private Long userId; 
	 
private String firstName; 
	 
	 private String lastName;
	 
	 private String phone;
	 
	 private String email; 
	 
	 public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	 

	 
	 
	 public User() { 
	 } 
	 
	 public User( String firstName, String lastName,
	   String email,String phone) {  
	  this.firstName = firstName; 
	  this.lastName = lastName; 
	  this.email = email; 
	  this.phone = phone;
	 
	 } 
	 
	 public Long getUserId() { 
	  return userId; 
	 } 
	 
	 
	 public String getFirstName() { 
	  return firstName; 
	 } 
	 
	 public String getLastName() { 
	  return lastName; 
	 } 
	 
	 public String getEmail() { 
	  return email; 
	 } 
	 public String getPhone(){
	  return phone;
	 }
	 
	
	 
	}



