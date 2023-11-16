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
            List<Multa> multasDoPrimeiroVeiculo = primeiroVeiculo.getMultas();

            if (multasDoPrimeiroVeiculo == null || multasDoPrimeiroVeiculo.isEmpty()) {
                Multa multa1Veiculo1 = criarMulta("Gothan City", "Farol apagado", 250f, primeiroVeiculo);
                Multa multa2Veiculo1 = criarMulta("Gothan City", "Insulfilm", 100f, primeiroVeiculo);

                salvarMultaSeNaoExistir(multa1Veiculo1);
                salvarMultaSeNaoExistir(multa2Veiculo1);
            }
        }

        Veiculo segundoVeiculo = veiculoRepository.findById("BCA-4321").orElse(null);
        if (segundoVeiculo != null) {
            List<Multa> multasDoSegundoVeiculo = segundoVeiculo.getMultas();

            if (multasDoSegundoVeiculo == null || multasDoSegundoVeiculo.isEmpty()) {
                Multa multa1Veiculo2 = criarMulta("Hiper-espaço", "Excesso velocidade", 400f, segundoVeiculo);

                salvarMultaSeNaoExistir(multa1Veiculo2);
            }
        }
    }

    public Multa criarMulta(String local, String motivo, Float valor, Veiculo veiculo) {
        Multa multa = new Multa();
        multa.setLocal(local);
        multa.setMotivo(motivo);
        multa.setValor(valor);
        multa.setVeiculo(veiculo);
        return multa;
    }

    public void salvarMultaSeNaoExistir(Multa multa) {
        // Verifica se a multa já existe no banco com base em critérios específicos
        Multa multaExistente = multaRepository.findByLocalAndMotivoAndValor(
                multa.getLocal(), multa.getMotivo(), multa.getValor());

        if (multaExistente == null) {
            multaRepository.save(multa);
        }
    }




    // Método para alterar o valor da multa do segundo veículo
//    public void alterarValorSegundaMultaSegundoVeiculo() {
//        // Buscando o segundo veículo
//        Veiculo segundoVeiculo = veiculoRepository.findById("BCA-4321").orElse(null);
//
//        // Verificando se o segundo veículo existe
//        if (segundoVeiculo != null && segundoVeiculo.getMultas() != null) {
//            List<Multa> multas = segundoVeiculo.getMultas();
//
//            // Buscando a segunda multa do segundo veículo
//            Multa segundaMulta = multas.stream()
//                    .filter(multa -> "Insulfilm".equals(multa.getMotivo()))
//                    .skip(1) // Pular a primeira ocorrência do motivo "Insulfilm"
//                    .findFirst()
//                    .orElse(null);
//
//            // Verificando se a segunda multa foi encontrada
//            if (segundaMulta != null) {
//                segundaMulta.setValor(380.0f); // Alterando o valor para 380 reais
//                multaRepository.save(segundaMulta); // Salvando a alteração no banco de dados
//            }
//        }

}