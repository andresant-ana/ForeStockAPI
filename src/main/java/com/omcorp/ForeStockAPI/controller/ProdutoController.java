package com.omcorp.ForeStockAPI.controller;

import com.omcorp.ForeStockAPI.model.Produto;
import com.omcorp.ForeStockAPI.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Optional<Produto> produto = produtoService.findById(id);
        if (produto.isPresent()) {
            Produto updatedProduto = produto.get();
            updatedProduto.setNome(produtoDetails.getNome());
            updatedProduto.setMarca(produtoDetails.getMarca());
            updatedProduto.setCategoria(produtoDetails.getCategoria());
            updatedProduto.setPreco(produtoDetails.getPreco());
            updatedProduto.setQuantidade(produtoDetails.getQuantidade());
            updatedProduto.setDataDeValidade(produtoDetails.getDataDeValidade());
            updatedProduto.setCodigoDeBarras(produtoDetails.getCodigoDeBarras());
            updatedProduto.setFornecedor(produtoDetails.getFornecedor());
            return ResponseEntity.ok(produtoService.save(updatedProduto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}