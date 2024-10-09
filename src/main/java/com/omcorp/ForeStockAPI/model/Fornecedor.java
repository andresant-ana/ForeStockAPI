package com.omcorp.ForeStockAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome do fornecedor não pode estar vazio")
    @Size(min = 3, max = 255, message = "O nome do fornecedor deve ter entre 3 e 255 caracteres")
    private String nome;
    @NotEmpty(message = "O telefone do fornecedor não pode estar vazio")
    @Size(min = 8, max = 20, message = "O telefone do fornecedor deve ter entre 8 e 20 caracteres")
    private String telefone;
    @NotEmpty(message = "O email do fornecedor não pode estar vazio")
    @Size(min = 8, max = 255, message = "O email do fornecedor deve ter entre 8 e 255 caracteres")
    private String email;
    @NotEmpty(message = "O CNPJ do fornecedor não pode estar vazio")
    @Size(min = 14, max = 14, message = "O CNPJ do fornecedor deve ter 14 caracteres")
    private String cnpj;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String nome, String telefone, String email, String cnpj, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "O nome do fornecedor não pode estar vazio") @Size(min = 3, max = 255, message = "O nome do fornecedor deve ter entre 3 e 255 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "O nome do fornecedor não pode estar vazio") @Size(min = 3, max = 255, message = "O nome do fornecedor deve ter entre 3 e 255 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotEmpty(message = "O telefone do fornecedor não pode estar vazio") @Size(min = 8, max = 20, message = "O telefone do fornecedor deve ter entre 8 e 20 caracteres") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotEmpty(message = "O telefone do fornecedor não pode estar vazio") @Size(min = 8, max = 20, message = "O telefone do fornecedor deve ter entre 8 e 20 caracteres") String telefone) {
        this.telefone = telefone;
    }

    public @NotEmpty(message = "O email do fornecedor não pode estar vazio") @Size(min = 8, max = 255, message = "O email do fornecedor deve ter entre 8 e 255 caracteres") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "O email do fornecedor não pode estar vazio") @Size(min = 8, max = 255, message = "O email do fornecedor deve ter entre 8 e 255 caracteres") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "O CNPJ do fornecedor não pode estar vazio") @Size(min = 14, max = 14, message = "O CNPJ do fornecedor deve ter 14 caracteres") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotEmpty(message = "O CNPJ do fornecedor não pode estar vazio") @Size(min = 14, max = 14, message = "O CNPJ do fornecedor deve ter 14 caracteres") String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}