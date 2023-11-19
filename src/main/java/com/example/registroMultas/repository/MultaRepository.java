package com.example.registroMultas.repository;

import com.example.registroMultas.model.Multa;
import com.example.registroMultas.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MultaRepository extends JpaRepository<Multa, Long> {
    Multa findByLocalAndMotivoAndValor(String local, String motivo, Float valor);
    List<Multa> findByVeiculo(Veiculo veiculo);
}
