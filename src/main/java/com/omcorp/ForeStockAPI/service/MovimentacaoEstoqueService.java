package com.omcorp.ForeStockAPI.service;

import com.omcorp.ForeStockAPI.model.MovimentacaoEstoque;
import com.omcorp.ForeStockAPI.repository.MovimentacaoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    public List<MovimentacaoEstoque> findAll() {
        return movimentacaoEstoqueRepository.findAll();
    }

    public Optional<MovimentacaoEstoque> findById(Long id) {
        return movimentacaoEstoqueRepository.findById(id);
    }

    public MovimentacaoEstoque save(MovimentacaoEstoque movimentacaoEstoque) {
        return movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }

    public void deleteById(Long id) {
        movimentacaoEstoqueRepository.deleteById(id);
    }
}