package com.example.timeDeFutebol.services;

import java.util.List;
import java.util.Optional;

import com.example.timeDeFutebol.model.Jogador;
import com.example.timeDeFutebol.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class JogadorServices {
    
    @Autowired
    private JogadorRepository repositorio;

    public Jogador criarJogador(Jogador jogador){ // cadastra jogadores
        Jogador j = new Jogador();
        j.setNumero(jogador.getNumero());

        Optional<Jogador> JogadorEncontrado = repositorio.findOne(Example.of(j));



        if(JogadorEncontrado.isPresent()){ // não deixa cadastrar novo jogador com mesmo numero de camisa
            return null;
        }else{
            return repositorio.insert(jogador);
        }        
    }

    public List<Jogador> obterTodos(){ // obtem todos os jogadores
        return repositorio.findAll();
    }

    public Jogador atualizar(String id, int numero){ // atualiza numero da camisa do jogador
        Optional<Jogador> registro = repositorio.findById(id);

        if(!registro.isEmpty()){
            Jogador jogador = registro.get();
            jogador.setNumero(numero);
            return repositorio.save(jogador);
        }else{
            return null;
        }
    }

    public void deletarJogador(String id){ // deleta jogadores por numero de id
        repositorio.deleteById(id);
    }

    public Jogador obterJogador(String id){ // encontra apenas um jogador expecifico
        Optional<Jogador> optional = repositorio.findById(id);
        return optional.isEmpty() ? null : optional.get();
    }
} 


