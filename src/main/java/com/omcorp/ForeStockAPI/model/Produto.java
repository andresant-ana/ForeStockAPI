package com.omcorp.ForeStockAPI.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome do produto não pode estar vazio")
    private String nome;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca")
    @Valid
    private Marca marca;
    private String categoria;
    @NotNull(message = "O preço do produto não pode estar vazio")
    @Positive(message = "O preço do produto deve ser positivo")
    private Double preco;
    @NotNull(message = "A quantidade do produto não pode estar vazia")
    @Positive(message = "A quantidade do produto deve ser positiva")
    private Integer quantidade;
    private LocalDate dataDeValidade;
    private String codigoDeBarras;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;
    
    public class ProdutoBuilder{
        private Long id;
        private String nome;
        private Marca marca;
        private String categoria;
        private Double preco;
        private Integer quantidade;
        private LocalDate dataDeValidade;
        private String codigoDeBarras;
        private Fornecedor fornecedor;
        
        public ProdutoBuilder setId(Long id){
            this.id = id;
            return this;
        }
        
        public ProdutoBuilder setNome(String nome){
            this.nome = nome;
            return this;
        }
        
        public ProdutoBuilder setMarca(Marca marca){
            this.marca = marca;
            return this;
        }
        
        public ProdutoBuilder setCategoria(String categoria){
            this.categoria = categoria;
            return this;
        }
        
        public ProdutoBuilder setPreco(Double preco){
            this.preco = preco;
            return this;
        }
        
        public ProdutoBuilder setQuantidade(Integer quantidade){
            this.quantidade = quantidade;
            return this;
        }
        
        public ProdutoBuilder setDataDeValidade(LocalDate dataDeValidade){
            this.dataDeValidade = dataDeValidade;
            return this;
        }
        
        public ProdutoBuilder setCodigoDeBarras(String codigoDeBarras){
            this.codigoDeBarras = codigoDeBarras;
            return this;
        }
        
        public ProdutoBuilder setFornecedor(Fornecedor fornecedor){
            this.fornecedor = fornecedor;
            return this;
        }
        
        public Produto build(){
            return new Produto(this);
        }
    }
    
    public Produto(ProdutoBuilder pb){
        this.id = pb.id;
        this.nome = pb.nome;
        this.marca = pb.marca;
        this.categoria = pb.categoria;
        this.preco = pb.preco;
        this.quantidade = pb.quantidade;
        this.dataDeValidade = pb.dataDeValidade;
        this.codigoDeBarras = pb.codigoDeBarras;
        this.fornecedor = pb.fornecedor;
    }
    
    public Produto(){
        
    }
    
    public Produto(Long id, String nome, Marca marca, String categoria, Double preco, Integer quantidade, LocalDate dataDeValidade, String codigoDeBarras, Fornecedor fornecedor){
        super();
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataDeValidade = dataDeValidade;
        this.codigoDeBarras = codigoDeBarras;
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "O nome do produto não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty(message = "O nome do produto não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @Valid Marca getMarca() {
        return marca;
    }

    public void setMarca(@Valid Marca marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public @NotNull(message = "O preço do produto não pode estar vazio") @Positive(message = "O preço do produto deve ser positivo") Double getPreco() {
        return preco;
    }

    public void setPreco(@NotNull(message = "O preço do produto não pode estar vazio") @Positive(message = "O preço do produto deve ser positivo") Double preco) {
        this.preco = preco;
    }

    public @NotNull(message = "A quantidade do produto não pode estar vazia") @Positive(message = "A quantidade do produto deve ser positiva") Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull(message = "A quantidade do produto não pode estar vazia") @Positive(message = "A quantidade do produto deve ser positiva") Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
