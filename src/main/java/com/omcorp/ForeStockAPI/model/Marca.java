package com.omcorp.ForeStockAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "marca")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Não é possível cadastrar uma marca sem nome")
    @Size(min = 3, max = 255, message = "O nome da marca deve ter entre 3 e 255 caracteres")
    private String nome;
    
    public Marca() {
        
    }
    
    public Marca(Long id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Não é possível cadastrar uma marca sem nome") @Size(min = 3, max = 255, message = "O nome da marca deve ter entre 3 e 255 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "Não é possível cadastrar uma marca sem nome") @Size(min = 3, max = 255, message = "O nome da marca deve ter entre 3 e 255 caracteres") String nome) {
        this.nome = nome;
    }
}
