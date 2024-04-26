package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Contato;
import com.example.demo.repositorio.ContatoRepositorio;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepositorio repositorio;

    //metodo para listar todos os usuarios
    @GetMapping
    public List<Contato> listar(){
        return repositorio.findAll();     
    }

    //metodo para listar o usuario pelo id
    @GetMapping("/contatos/{id}")
    public ResponseEntity<Object> getOneContato(@PathVariable(value = "id") Long id){
        Optional<Contato> contat0 = repositorio.findById(id);
        if (contat0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contat0.get());
    }

    //metodo para criar usuario
    @PostMapping //requisicao
    public Contato adicionar(@RequestBody Contato contato){
        return repositorio.save(contato);
    }

    //atualizar o usuario
    @PutMapping
    public Contato alterar(@RequestBody Contato contato){
        if (contato.getId()>0)
            return repositorio.save(contato);
        return null;
    }

    //deletar o usuario
    public String deletar(@RequestBody Contato contato){
        if (contato.getId()>0){
            repositorio.delete(contato);
            return "Contato deletado com sucesso";
        }
        return "Contato não encontrado";
        
    }


}
