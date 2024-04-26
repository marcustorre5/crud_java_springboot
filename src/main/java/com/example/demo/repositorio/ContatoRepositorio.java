package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Contato;

public interface ContatoRepositorio extends JpaRepository<Contato, Long>{

    

}
