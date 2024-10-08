package com.etapa7e8.construcao.repository;

import com.etapa7e8.construcao.model.Funcionario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
     List<Funcionario> findByNomeFuncionarioContainingIgnoreCase(String nome);
    Optional<Funcionario> findByCpfFuncionario(String cpfFuncionario);
}