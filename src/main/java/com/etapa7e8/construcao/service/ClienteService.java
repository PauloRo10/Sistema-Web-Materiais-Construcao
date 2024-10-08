package com.etapa7e8.construcao.service;

import com.etapa7e8.construcao.model.Cliente;
import com.etapa7e8.construcao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Salvar ou atualizar cliente
    public Cliente saveCliente(Cliente cliente) {
        // Verifica se já existe um cliente com o mesmo CPF
        Optional<Cliente> clienteExistente = clienteRepository.findByCpfCliente(cliente.getCpfCliente());
        if (clienteExistente.isPresent()) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com este CPF.");
        }
        
        // Se não existir, salva o novo cliente
        return clienteRepository.save(cliente);
    }

    // Buscar cliente por CPF
    public Optional<Cliente> buscarClientePorCpf(String cpfCliente) {
        return clienteRepository.findByCpfCliente(cpfCliente);
    }

    // Listar todos os clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Excluir cliente por CPF
    public boolean deleteClienteByCpf(String cpfCliente) {
        Optional<Cliente> cliente = clienteRepository.findByCpfCliente(cpfCliente);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return true;
        }
        return false;
    }

    // Atualizar cliente
    public Cliente updateCliente(Cliente clienteAtualizado) {
    Optional<Cliente> clienteExistenteOptional = clienteRepository.findByCpfCliente(clienteAtualizado.getCpfCliente());

    if (clienteExistenteOptional.isPresent()) {
        Cliente clienteExistente = clienteExistenteOptional.get();

        clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
        clienteExistente.setRgCliente(clienteAtualizado.getRgCliente());
        clienteExistente.setTelefoneCliente(clienteAtualizado.getTelefoneCliente());
        clienteExistente.setEnderecoCliente(clienteAtualizado.getEnderecoCliente());
        clienteExistente.setCepCliente(clienteAtualizado.getCepCliente());

        return clienteRepository.save(clienteExistente);
    } else {
        throw new IllegalArgumentException("Cliente não encontrado com CPF: " + clienteAtualizado.getCpfCliente());
    }
    
}
     public Cliente buscarPorCpf(String cpfCliente) {
        return clienteRepository.findByCpfCliente(cpfCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado para o CPF: " + cpfCliente));
    }
}