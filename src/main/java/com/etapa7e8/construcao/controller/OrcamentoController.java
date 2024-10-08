package com.etapa7e8.construcao.controller;

import com.etapa7e8.construcao.model.Cliente;
import com.etapa7e8.construcao.model.Estoque;
import com.etapa7e8.construcao.model.Funcionario;
import com.etapa7e8.construcao.model.Orcamento;
import com.etapa7e8.construcao.service.ClienteService;
import com.etapa7e8.construcao.service.EstoqueService;
import com.etapa7e8.construcao.service.FuncionarioService;
import com.etapa7e8.construcao.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ClienteService clienteService;

    // Exibe a página de criação do orçamento sem buscar dados
    @GetMapping("/novo")
    public String exibirFormularioOrcamento(Model model) {
        model.addAttribute("orcamento", new Orcamento());
        return "paginaOrcamento";
    }

    // Busca de funcionário por nome
    @PostMapping("/buscar-funcionario")
    @ResponseBody
    public List<Funcionario> buscarFuncionarioPorNome(@RequestParam("nomeFuncionario") String nomeFuncionario) {
        return funcionarioService.buscarPorNome(nomeFuncionario);
    }

    // Busca de cliente por CPF
    @PostMapping("/buscar-cliente")
    @ResponseBody
    public Cliente buscarClientePorCpf(@RequestParam("cpfCliente") String cpfCliente) {
        return clienteService.buscarPorCpf(cpfCliente);
    }

    // Busca de produtos por nome
    @PostMapping("/buscar-produto")
    @ResponseBody
    public List<Estoque> buscarProdutoPorNome(@RequestParam("nomeProduto") String nomeProduto) {
        return estoqueService.buscarPorNome(nomeProduto);
    }

    // Salvar o orçamento com produtos adicionados
    @PostMapping("/salvar")
    public String salvarOrcamento(@ModelAttribute Orcamento orcamento, @RequestParam("cpfCliente") String cpfCliente, 
                                  @RequestParam("cpfFuncionario") String cpfFuncionario, Model model) {
        try {
            orcamentoService.salvarOrcamento(orcamento, cpfCliente, cpfFuncionario);
            model.addAttribute("mensagemSucesso", "Orçamento salvo com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/orcamento/novo";
    }
}