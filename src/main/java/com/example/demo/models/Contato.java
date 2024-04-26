package com.example.demo.models;

//importacoes
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//cria a tabela contato no banco de dados
@Entity
public class Contato {
    
    //cria o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //cira o nome
    @Column(nullable = false)
    private String nome;
    
    //cira o telefone
    @Column(nullable = false)
    private String telefone;

    //cria email
    @Column(nullable = false)
    private String email;

    //getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
