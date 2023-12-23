package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ClientController {
	
	@Autowired
	ClientRepository clientrepository;

	@GetMapping("/clients")
	public List<Client> findAll() {
		return clientrepository.findAll();
	}

	@GetMapping("/client/{id}")
	public Optional<Client> findById(@PathVariable Long id) {
		return clientrepository.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clientrepository.deleteById(id);
	}
	
	
	
	

}
