package com.etapa7e8.construcao.service;

import com.etapa7e8.construcao.model.Cliente;
import com.etapa7e8.construcao.model.Funcionario;
import com.etapa7e8.construcao.model.Orcamento;
import com.etapa7e8.construcao.repository.ClienteRepository;
import com.etapa7e8.construcao.repository.EstoqueRepository;
import com.etapa7e8.construcao.repository.FuncionarioRepository;
import com.etapa7e8.construcao.repository.OrcamentoRepository;
import com.etapa7e8.construcao.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    public Orcamento salvarOrcamento(Orcamento orcamento) {
        return orcamentoRepository.save(orcamento);
    }

    public List<Orcamento> listarTodosOrcamentos() {
        return orcamentoRepository.findAll();
    }

    public Optional<Orcamento> buscarOrcamentoPorId(int id) {
        return orcamentoRepository.findById(id);
    }

    public void excluirOrcamento(int id) {
        orcamentoRepository.deleteById(id);
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpfCliente(cpf);
    }

    public Optional<Funcionario> buscarFuncionarioPorCpf(String cpf) {
        return funcionarioRepository.findByCpfFuncionario(cpf);
    }

    public Orcamento criarOrcamento(Orcamento orcamento, String cpfCliente, String cpfFuncionario) {
        // Verifica se o cliente existe no banco
        Optional<Cliente> cliente = buscarClientePorCpf(cpfCliente);
        if (cliente.isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        // Verifica se o funcionário existe no banco
        Optional<Funcionario> funcionario = buscarFuncionarioPorCpf(cpfFuncionario);
        if (funcionario.isEmpty()) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }

        // Define o cliente e o funcionário no orçamento
        orcamento.setCliente(cliente.get());
        orcamento.setFuncionario(funcionario.get());

        // Salva o orçamento
        return orcamentoRepository.save(orcamento);
    }
     public void salvarOrcamento(Orcamento orcamento, String cpfCliente, String cpfFuncionario) {
        // Buscar cliente e funcionário
        Cliente cliente = clienteRepository.findByCpfCliente(cpfCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Funcionario funcionario = funcionarioRepository.findByCpfFuncionario(cpfFuncionario)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        // Definir cliente e funcionário no orçamento
        orcamento.setCliente(cliente);
        orcamento.setFuncionario(funcionario);

        // Salvar o orçamento no banco de dados
        orcamentoRepository.save(orcamento);
    }
}