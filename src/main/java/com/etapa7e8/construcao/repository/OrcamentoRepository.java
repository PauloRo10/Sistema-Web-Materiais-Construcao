package com.etapa7e8.construcao.repository;

import com.etapa7e8.construcao.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
    List<Orcamento> findByClienteCpfCliente(String cpfCliente);
}