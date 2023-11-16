package com.example.registroMultas;

import com.example.registroMultas.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistroMultasApplication implements CommandLineRunner {

	private final VeiculoService veiculoService;

	@Autowired
	public RegistroMultasApplication(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	public static void main(String[] args) {

		SpringApplication.run(RegistroMultasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		veiculoService.salvarVeiculos();
	}

}
