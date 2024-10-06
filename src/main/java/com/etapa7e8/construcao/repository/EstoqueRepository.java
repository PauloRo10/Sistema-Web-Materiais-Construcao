package com.etapa7e8.construcao.repository;

import com.etapa7e8.construcao.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Optional<Estoque> findByCodigo(int codigo);
}