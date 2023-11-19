package com.example.registroMultas;

import com.example.registroMultas.model.Veiculo;
import com.example.registroMultas.service.MultaService;
import com.example.registroMultas.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RegistroMultasApplication implements CommandLineRunner {

	private final VeiculoService veiculoService;
	private final MultaService multaService;

	@Autowired
	public RegistroMultasApplication(VeiculoService veiculoService, MultaService multaService) {
		this.veiculoService = veiculoService;
		this.multaService = multaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RegistroMultasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//veiculoService.salvarVeiculos();
		//multaService.salvarMultas();
		//multaService.alterarValorSegundaMultaSegundoVeiculo();

		List<Veiculo> veiculosComMultas = veiculoService.buscarVeiculosComMultas();
		for (Veiculo veiculo : veiculosComMultas) {
			System.out.println(veiculo.toString());
		}
	}
}

