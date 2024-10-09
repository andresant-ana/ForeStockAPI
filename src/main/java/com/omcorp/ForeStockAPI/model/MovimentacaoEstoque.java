package com.omcorp.ForeStockAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @NotNull(message = "A quantidade não pode estar vazia")
    private Integer quantidade;
    @NotNull(message = "A data da movimentação não pode estar vazia")
    private LocalDateTime dataMovimentacao;

    public MovimentacaoEstoque() {
    }
    
    public MovimentacaoEstoque(Produto produto, Integer quantidade, LocalDateTime dataMovimentacao) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public @NotNull(message = "A quantidade não pode estar vazia") Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull(message = "A quantidade não pode estar vazia") Integer quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull(message = "A data da movimentação não pode estar vazia") LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(@NotNull(message = "A data da movimentação não pode estar vazia") LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}