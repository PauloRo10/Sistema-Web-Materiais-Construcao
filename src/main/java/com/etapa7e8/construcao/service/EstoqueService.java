package com.etapa7e8.construcao.service;

import com.etapa7e8.construcao.model.Estoque;
import com.etapa7e8.construcao.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Cadastrar ou atualizar um produto no estoque
    public Estoque salvarProduto(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    // Buscar produto por código
    public Optional<Estoque> buscarPorCodigo(int codigo) {
        return estoqueRepository.findByCodigo(codigo);
    }

    // Entrada de produto no estoque
    public Estoque entradaProduto(int codigo, int quantidade) {
        Optional<Estoque> produtoOpt = estoqueRepository.findByCodigo(codigo);
        if (produtoOpt.isPresent()) {
            Estoque produto = produtoOpt.get();
            produto.adicionarQuantidade(quantidade);
            return estoqueRepository.save(produto);
        } else {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
    }

    // Saída de produto no estoque
    public Estoque saidaProduto(int codigo, int quantidade) {
        Optional<Estoque> produtoOpt = estoqueRepository.findByCodigo(codigo);
        if (produtoOpt.isPresent()) {
            Estoque produto = produtoOpt.get();
            produto.retirarQuantidade(quantidade);
            return estoqueRepository.save(produto);
        } else {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
    }

    // Listar todos os produtos no estoque
    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    // Excluir produto por código
    public void excluirProduto(int codigo) {
        Optional<Estoque> produto = estoqueRepository.findByCodigo(codigo);
        produto.ifPresent(estoqueRepository::delete);
    }
    public Optional<Estoque> buscarPorId(int idEstoque) {
    return estoqueRepository.findById(idEstoque);
}
}