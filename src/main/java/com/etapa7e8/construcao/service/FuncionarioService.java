package com.etapa7e8.construcao.service;

import com.etapa7e8.construcao.model.Funcionario;
import com.etapa7e8.construcao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario saveFuncionario(Funcionario funcionario) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByCpfFuncionario(funcionario.getCpfFuncionario());
        if (funcionarioExistente.isPresent()) {
            throw new IllegalArgumentException("Já existe um funcionário com este CPF.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioPorCpf(String cpfFuncionario) {
        return funcionarioRepository.findByCpfFuncionario(cpfFuncionario);
    }

    public boolean deleteFuncionarioByCpf(String cpfFuncionario) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByCpfFuncionario(cpfFuncionario);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return true;
        }
        return false;
    }

    public Funcionario updateFuncionario(Funcionario funcionarioAtualizado) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findByCpfFuncionario(funcionarioAtualizado.getCpfFuncionario());

        if (funcionarioExistente.isPresent()) {
            Funcionario funcionario = funcionarioExistente.get();
            funcionario.setNomeFuncionario(funcionarioAtualizado.getNomeFuncionario());
            funcionario.setRgFuncionario(funcionarioAtualizado.getRgFuncionario());
            funcionario.setTelefoneFuncionario(funcionarioAtualizado.getTelefoneFuncionario());
            funcionario.setEnderecoFuncionario(funcionarioAtualizado.getEnderecoFuncionario());
            funcionario.setCepFuncionario(funcionarioAtualizado.getCepFuncionario());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSalario(funcionarioAtualizado.getSalario());

            return funcionarioRepository.save(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }
    }
    public List<Funcionario> buscarPorNome(String nomeFuncionario) {
        return funcionarioRepository.findByNomeFuncionarioContainingIgnoreCase(nomeFuncionario);
    }
}