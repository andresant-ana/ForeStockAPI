package com.omcorp.ForeStockAPI.repository;

import com.omcorp.ForeStockAPI.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}