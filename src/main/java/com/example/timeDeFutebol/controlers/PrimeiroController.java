package com.example.timeDeFutebol.controlers;

import java.util.List;

import com.example.timeDeFutebol.model.Jogador;
import com.example.timeDeFutebol.services.JogadorServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jogador")
public class PrimeiroController {
    
    @Autowired
    private JogadorServices servico;
    
    @PostMapping
    public ResponseEntity<Jogador> criarProduto(@RequestBody Jogador jogador) {
        Jogador jogadorCriado = servico.criarJogador(jogador);

        if (jogadorCriado == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(jogadorCriado, HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> obterTodps(){
        List<Jogador> produto = servico.obterTodos();
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PutMapping("/{id}/{numero}")
    public ResponseEntity<Jogador> atualizarNumero(@PathVariable String id, @PathVariable int numero){
        Jogador jogador = servico.atualizar(id, numero);

        if(jogador == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(jogador, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarJogador(@PathVariable String id){
        servico.deletarJogador(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> obterJogador(@PathVariable String id){
        return new ResponseEntity<>(servico.obterJogador(id), HttpStatus.OK);
    }
}
