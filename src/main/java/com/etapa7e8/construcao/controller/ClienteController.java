package com.etapa7e8.construcao.controller;

import com.etapa7e8.construcao.model.Cliente;
import com.etapa7e8.construcao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Cadastro de Cliente (POST)
    @PostMapping("/cadastrar")
    public String cadastrarCliente(@ModelAttribute Cliente cliente, Model model) {
        try {
            clienteService.saveCliente(cliente);
            // Adiciona uma mensagem de sucesso
            model.addAttribute("mensagemSucesso", "Cliente cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "paginaCliente"; // Retorna à página de cadastro com a mensagem de erro
        }

        return "cliente-detalhe"; // Retorna à página de detalhes com a mensagem de sucesso
    }

    // Buscar Cliente por CPF (GET)
    @GetMapping("/buscar")
    public String buscarClientePorCpf(@RequestParam("cpfCliente") String cpfCliente, Model model) {
        Optional<Cliente> cliente = clienteService.buscarClientePorCpf(cpfCliente);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente-detalhe"; 
        } else {
            model.addAttribute("mensagemErro", "Cliente não encontrado");
            return "pagina-cliente";
        }
    }

    // Excluir Cliente por CPF (GET)
    @GetMapping("/excluir")
public String excluirCliente(@RequestParam("cpfCliente") String cpfCliente, Model model) {
    boolean excluido = clienteService.deleteClienteByCpf(cpfCliente);
    if (excluido) {
        // Adiciona uma mensagem de sucesso após a exclusão
        model.addAttribute("mensagemSucesso", "Cliente excluído com sucesso.");
    } else {
        // Se o cliente não foi encontrado, exibe uma mensagem de erro
        model.addAttribute("mensagemErro", "Cliente não encontrado.");
    }
    return "paginaCliente";  // Redireciona para a página de listagem após exclusão
}

    // Listar todos os clientes (GET)
    @GetMapping("/listar")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "paginaCliente";
    }
    
    // Mostrar o formulário de edição de cliente (GET)
    @GetMapping("/editar")
public String mostrarFormularioEdicao(@RequestParam("cpfCliente") String cpfCliente, Model model) {
    Optional<Cliente> clienteOptional = clienteService.buscarClientePorCpf(cpfCliente);

    if (clienteOptional.isPresent()) {
        Cliente cliente = clienteOptional.get();
        model.addAttribute("cliente", cliente);
        return "editar-cliente";
    } else {
        return "redirect:/clientes/listar";
    }
}

    // Atualizar os dados do cliente (POST)
    @PostMapping("/atualizar")
public String atualizarCliente(@ModelAttribute("cliente") Cliente clienteAtualizado, Model model) {
    // Atualiza os dados do cliente
    clienteService.updateCliente(clienteAtualizado);

    // Adiciona uma mensagem de sucesso ao modelo
    model.addAttribute("mensagemSucesso", "Cliente atualizado com sucesso!");

    // Retorna à página de detalhes do cliente
    model.addAttribute("cliente", clienteAtualizado);  // Adiciona o cliente atualizado ao modelo
    return "cliente-detalhe";  // Nome do template de detalhes
}
@GetMapping("/pagina-Cliente")
public String mostrarPaginaCliente() {
    return "paginaCliente"; // Nome do arquivo HTML da página cliente
}
}