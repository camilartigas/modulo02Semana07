package com.example.registroMultas.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Multas")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // identificador sequencial

    private String local;

    private String motivo;

    private Float valor;

    @ManyToOne //muitas multas para 1 placa
    @JoinColumn(name = "placa") // nome da coluna
    private Veiculo veiculo; // relacionamento bi-direcional


    @Override
    public String toString() {
        return "Multa - Motivo: " + motivo + ", Local: " + local + ", Valor: " + valor;
    }


    // getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
