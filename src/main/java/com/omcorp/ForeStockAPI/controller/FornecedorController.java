package com.omcorp.ForeStockAPI.controller;

import com.omcorp.ForeStockAPI.model.Fornecedor;
import com.omcorp.ForeStockAPI.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> getFornecedorById(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.findById(id);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedorDetails) {
        Optional<Fornecedor> fornecedor = fornecedorService.findById(id);
        if (fornecedor.isPresent()) {
            Fornecedor updatedFornecedor = fornecedor.get();
            updatedFornecedor.setNome(fornecedorDetails.getNome());
            updatedFornecedor.setTelefone(fornecedorDetails.getTelefone());
            updatedFornecedor.setEmail(fornecedorDetails.getEmail());
            updatedFornecedor.setCnpj(fornecedorDetails.getCnpj());
            updatedFornecedor.setProdutos(fornecedorDetails.getProdutos());
            return ResponseEntity.ok(fornecedorService.save(updatedFornecedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        fornecedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}