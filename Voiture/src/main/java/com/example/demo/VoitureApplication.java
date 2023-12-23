package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Client;
import com.example.demo.entities.Car;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.VoitureRepository;

@SpringBootApplication
public class VoitureApplication {

	/*@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}*/
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory= new
				SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(50000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);

		return  restTemplate;
	}
	
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientRepository clientRepository) {
		return args -> {
			Client clients = clientRepository.save(new Client(Long.parseLong("1"),"Boutayeb majda ",Float.parseFloat("23")));
			voitureRepository.save(new Car(1L, "test", "test", "BMW", clients));
			//voitureRepository.save(new Car(2L, "test2", "Atest2", "BMW", clients));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

}
