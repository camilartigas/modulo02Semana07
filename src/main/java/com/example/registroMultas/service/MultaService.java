package com.example.registroMultas.service;

import com.example.registroMultas.model.Multa;
import com.example.registroMultas.model.Veiculo;
import com.example.registroMultas.repository.MultaRepository;
import com.example.registroMultas.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    private final MultaRepository multaRepository;
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public MultaService(MultaRepository multaRepository, VeiculoRepository veiculoRepository) {
        this.multaRepository = multaRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional
    public void salvarMultas() {
        Veiculo primeiroVeiculo = veiculoRepository.findById("ABC-1234").orElse(null);
        if (primeiroVeiculo != null) {
            Multa multa1Veiculo1 = new Multa();
            multa1Veiculo1.setMotivo("Farol apagado");
            multa1Veiculo1.setLocal("Gothan City");
            multa1Veiculo1.setValor(250f);
            multa1Veiculo1.setVeiculo(primeiroVeiculo);
            multaRepository.save(multa1Veiculo1);

            Multa multa2Veiculo1 = new Multa();
            multa2Veiculo1.setMotivo("Insulfilm");
            multa2Veiculo1.setLocal("Gothan City");
            multa2Veiculo1.setValor(100f);
            multa2Veiculo1.setVeiculo(primeiroVeiculo);
            multaRepository.save(multa2Veiculo1);
        }

        Veiculo segundoVeiculo = veiculoRepository.findById("BCA-4321").orElse(null);
        if (segundoVeiculo != null) {
            Multa multa1Veiculo2 = new Multa();
            multa1Veiculo2.setMotivo("Excesso velocidade");
            multa1Veiculo2.setLocal("Hiper-espaço");
            multa1Veiculo2.setValor(400f);
            multa1Veiculo2.setVeiculo(segundoVeiculo);
            multaRepository.save(multa1Veiculo2);
        }
    }
    @Transactional
    public void alterarValorSegundaMultaSegundoVeiculo() {
        Veiculo segundoVeiculo = veiculoRepository.findById("BCA-4321").orElse(null);

        if (segundoVeiculo != null && segundoVeiculo.getMultas() != null) {
            List<Multa> multas = segundoVeiculo.getMultas();

            for (Multa multa : multas) {
                if ("Excesso velocidade".equals(multa.getMotivo())) {
                    multa.setValor(380f);
                    multaRepository.save(multa);
                }
            }
        }
    }
}
