
package com.etapa7e8.construcao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pagina_inicialController {

    @GetMapping("/cliente")
    public String mostrarPaginaCliente() {
        return "paginaCliente"; // Nome do arquivo HTML da página de cliente
    }

    @GetMapping("/orcamento")
    public String mostrarPaginaOrcamento() {
        return "pagina_orcamento"; // Nome do arquivo HTML da página de orçamento
    }

    @GetMapping("/estoque")
    public String mostrarPaginaEstoque() {
        return "pagina_estoque"; // Nome do arquivo HTML da página de estoque
    }

    @GetMapping("/funcionario")
    public String mostrarPaginaFuncionario() {
        return "paginaFuncionario"; // Nome do arquivo HTML da página de funcionário
    }

    @GetMapping("/venda")
    public String mostrarPaginaVenda() {
        return "pagina_venda"; // Nome do arquivo HTML da página de venda
    }
}
