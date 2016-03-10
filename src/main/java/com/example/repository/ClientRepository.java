package com.example.repository;

import com.example.entity.Client;
import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository; 
 
public interface ClientRepository extends JpaRepository<Client, Long> { 
	
	
 
 List<Client> findByClientId(String clientId); 
 
 
 
}