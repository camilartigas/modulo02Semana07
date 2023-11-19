package com.example.registroMultas.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Veiculos")
public class Veiculo {

    @Id //chave primária
    @Column(name = "placa")
    private String placa; // chave primária na tabela

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String nome;

    private Integer anoFabricacao;

    private String cor;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)//um veículo para muitas multas
    private List<Multa> multas; // relacionamento bi-direcional


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veículo: ").append(nome).append(" - Placa: ").append(placa).append("\n");

        if (multas != null && !multas.isEmpty()) {
            sb.append("Multas:\n");
            for (Multa multa : multas) {
                sb.append("- Motivo: ").append(multa.getMotivo())
                        .append(", Local: ").append(multa.getLocal())
                        .append(", Valor: ").append(multa.getValor()).append("\n");
            }
        } else {
            sb.append("Sem multas.\n");
        }
        return sb.toString();
    }


    // getters e setters

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void setMultas(List<Multa> multas) {
        this.multas = multas;
    }
}
