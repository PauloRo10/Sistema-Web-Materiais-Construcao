package com.etapa7e8.construcao.repository;

import com.etapa7e8.construcao.model.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByCpfCliente(String cpfCliente);
    // Consulta para buscar o cliente com o maior ID
    //Cliente findTopByOrderByIdClienteDesc();
    
    
    
}
