package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Client;
import com.example.demo.entities.Car;
import com.example.demo.entities.CarResponse;
import com.example.demo.repositories.VoitureRepository;
import com.example.demo.services.VoitureService;

@RestController
@RequestMapping("/api/car")
public class VoitureController {

	
	@Autowired
	VoitureService voitureService;

	@GetMapping("")
	public List<CarResponse> findAll() {
		return voitureService.findAll();
	}

	@GetMapping("/{id}")
	public CarResponse findById(@PathVariable Long id) throws Exception {
		return voitureService.findById(id);
	}

	
	
	
	
}
