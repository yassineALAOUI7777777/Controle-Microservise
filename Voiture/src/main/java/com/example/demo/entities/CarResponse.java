package com.example.demo.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String model;
	private String matricule;
	private Client client;
	private String marque;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public static class Builder {
        private CarResponse carResponse;

        public Builder() {
            carResponse = new CarResponse();
        }

        public Builder id(Long id) {
            carResponse.id = id;
            return this;
        }

        public Builder brand(String brand) {
            carResponse.model = brand;
            return this;
        }

        public Builder client(Client client) {
            carResponse.client = client;
            return this;
        }

        public Builder matricule(String matricule) {
            carResponse.matricule = matricule;
            return this;
        }

        public Builder model(String model) {
            carResponse.model = model;
            return this;
        }

        public CarResponse build() {
            return carResponse;
        }
    }

    // Static method to create a new builder instance
    public static Builder builder() {
        return new Builder();
    }
	
	
	

}
