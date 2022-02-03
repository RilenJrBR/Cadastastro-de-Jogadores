package com.example.timeDeFutebol.model;

import org.springframework.data.annotation.Id;

public class Jogador {
    @Id
    private String id;
    private String nome;
    private Integer numero;
    private Double altura;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public Double getAltura() {
        return altura;
    }
    public void setAltura(Double altura) {
        this.altura = altura;
    }   
}
