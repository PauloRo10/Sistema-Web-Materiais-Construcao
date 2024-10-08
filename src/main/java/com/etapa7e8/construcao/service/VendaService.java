package com.etapa7e8.construcao.service;

import com.etapa7e8.construcao.model.Venda;
import com.etapa7e8.construcao.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    // Método para salvar uma venda
    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    // Método para buscar uma venda por ID
    public Optional<Venda> buscarVendaPorId(int id) {
        return vendaRepository.findById(id);
    }

    // Método para listar todas as vendas
    public List<Venda> listarTodasVendas() {
        return vendaRepository.findAll();
    }

    // Método para excluir uma venda
    public void excluirVenda(int id) {
        vendaRepository.deleteById(id);
    }
}