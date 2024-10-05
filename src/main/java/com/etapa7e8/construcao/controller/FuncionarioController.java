package com.etapa7e8.construcao.controller;

import com.etapa7e8.construcao.model.Funcionario;
import com.etapa7e8.construcao.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public String cadastrarFuncionario(@ModelAttribute Funcionario funcionario, Model model) {
        try {
            funcionarioService.saveFuncionario(funcionario);
            model.addAttribute("mensagemSucesso", "Funcionário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "paginaFuncionario";
        }
        return "funcionario-detalhe";
    }

    @GetMapping("/buscar")
    public String buscarFuncionarioPorCpf(@RequestParam("cpfFuncionario") String cpfFuncionario, Model model) {
        Optional<Funcionario> funcionario = funcionarioService.buscarFuncionarioPorCpf(cpfFuncionario);
        if (funcionario.isPresent()) {
            model.addAttribute("funcionario", funcionario.get());
            return "funcionario-detalhe";
        } else {
            model.addAttribute("mensagemErro", "Funcionário não encontrado.");
            return "paginaFuncionario";
        }
    }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "lista-funcionarios";
    }

    @GetMapping("/excluir")
    public String excluirFuncionario(@RequestParam("cpfFuncionario") String cpfFuncionario, Model model) {
        boolean excluido = funcionarioService.deleteFuncionarioByCpf(cpfFuncionario);
        if (excluido) {
            model.addAttribute("mensagemSucesso", "Funcionário excluído com sucesso.");
        } else {
            model.addAttribute("mensagemErro", "Funcionário não encontrado.");
        }
        return "paginaFuncionario";
    }

    @PostMapping("/atualizar")
    public String atualizarFuncionario(@ModelAttribute("funcionario") Funcionario funcionarioAtualizado, Model model) {
        funcionarioService.updateFuncionario(funcionarioAtualizado);
        model.addAttribute("mensagemSucesso", "Funcionário atualizado com sucesso!");
        model.addAttribute("funcionario", funcionarioAtualizado);
        return "funcionario-detalhe";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicao(@RequestParam("cpfFuncionario") String cpfFuncionario, Model model) {
        Optional<Funcionario> funcionario = funcionarioService.buscarFuncionarioPorCpf(cpfFuncionario);
        if (funcionario.isPresent()) {
            model.addAttribute("funcionario", funcionario.get());
            return "editar-funcionario";
        } else {
            return "redirect:/funcionarios/listar";
        }
    }
    @GetMapping("/pagina-Funcionario")
public String mostrarPaginaCliente() {
    return "paginaFuncionario"; // Nome do arquivo HTML da página cliente
}
}