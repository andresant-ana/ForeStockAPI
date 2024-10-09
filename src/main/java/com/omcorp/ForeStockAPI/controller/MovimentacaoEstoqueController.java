package com.omcorp.ForeStockAPI.controller;

import com.omcorp.ForeStockAPI.model.MovimentacaoEstoque;
import com.omcorp.ForeStockAPI.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @GetMapping
    public List<MovimentacaoEstoque> getAllMovimentacoes() {
        return movimentacaoEstoqueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoque> getMovimentacaoById(@PathVariable Long id) {
        Optional<MovimentacaoEstoque> movimentacao = movimentacaoEstoqueService.findById(id);
        return movimentacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MovimentacaoEstoque createMovimentacao(@RequestBody MovimentacaoEstoque movimentacao) {
        return movimentacaoEstoqueService.save(movimentacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoque> updateMovimentacao(@PathVariable Long id, @RequestBody MovimentacaoEstoque movimentacaoDetails) {
        Optional<MovimentacaoEstoque> movimentacao = movimentacaoEstoqueService.findById(id);
        if (movimentacao.isPresent()) {
            MovimentacaoEstoque updatedMovimentacao = movimentacao.get();
            updatedMovimentacao.setProduto(movimentacaoDetails.getProduto());
            updatedMovimentacao.setQuantidade(movimentacaoDetails.getQuantidade());
            updatedMovimentacao.setDataMovimentacao(movimentacaoDetails.getDataMovimentacao());
            return ResponseEntity.ok(movimentacaoEstoqueService.save(updatedMovimentacao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimentacao(@PathVariable Long id) {
        movimentacaoEstoqueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}