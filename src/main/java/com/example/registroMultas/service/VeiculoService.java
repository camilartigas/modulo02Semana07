package com.example.registroMultas.service;

import com.example.registroMultas.model.Multa;
import com.example.registroMultas.model.TipoVeiculo;
import com.example.registroMultas.model.Veiculo;
import com.example.registroMultas.repository.MultaRepository;
import com.example.registroMultas.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }


    public void salvarVeiculos() {
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setPlaca("ABC-1234");
        veiculo1.setTipo(TipoVeiculo.AUTOMOVEL);
        veiculo1.setNome("Bat-Movel");
        veiculo1.setAnoFabricacao(2022);
        veiculo1.setCor("preto");

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setPlaca("BCA-4321");
        veiculo2.setTipo(TipoVeiculo.ONIBUS);
        veiculo2.setNome("Enterprise");
        veiculo2.setAnoFabricacao(1960);
        veiculo2.setCor("prata");

        veiculoRepository.save(veiculo1);
        veiculoRepository.save(veiculo2);
    }

    @Autowired
    private MultaRepository multaRepository;

    public List<Veiculo> buscarVeiculosComMultas() {
        List<Veiculo> veiculos = veiculoRepository.findAll();

        for (Veiculo veiculo : veiculos) {
            List<Multa> multas = multaRepository.findByVeiculo(veiculo);
            veiculo.setMultas(multas);
        }

        return veiculos;
    }
}
