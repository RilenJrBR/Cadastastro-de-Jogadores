package com.example.timeDeFutebol.repository;

import com.example.timeDeFutebol.model.Jogador;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogadorRepository extends MongoRepository<Jogador, String> {
    
}