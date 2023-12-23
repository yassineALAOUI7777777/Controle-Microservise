package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Client;
import com.example.demo.entities.Car;
import com.example.demo.entities.CarResponse;
import com.example.demo.repositories.VoitureRepository;

@Service
public class VoitureService {
	
	@Autowired
	private VoitureRepository carRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	private final String URL="http://localhost:8888/SERVICE-CLIENT";
	
	public List<CarResponse> findAll() {
		List<Car> cars = carRepository.findAll();
		ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL+"/api/client/", Client [].class);
		Client[] clients = response.getBody();
		return cars.stream().map((Car car) ->
		mapToCarResponse(car, clients)).toList();
		}
	
	private CarResponse mapToCarResponse (Car car, Client[] clients) {
		Client foundClient = Arrays.stream(clients)
		.filter(client -> client.getId().equals(car.getId_client()))
		.findFirst()
		.orElse (null);
		
		return CarResponse.builder()
		.id(car.getId())
		.brand(car.getMarque())
		.client (foundClient)
		.matricule(car.getMatricule())
		.model(car.getModel())
		.build();
		}
	
	public CarResponse findById(Long id) throws Exception {
		Car car = carRepository.findById(id).orElseThrow(()->new Exception("Invalid Car Id"));
		Client client =
		restTemplate.getForObject(this.URL+"/api/client/"+car.getId_client(), Client.class); return CarResponse.builder()
		.id(car.getId())
		.brand(car.getModel())
		.client (client)
		.matricule(car.getMatricule()).model(car.getModel()).build();
		}
	
	
	
	
}
