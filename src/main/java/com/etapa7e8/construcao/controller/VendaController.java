package com.etapa7e8.construcao.controller;

import com.etapa7e8.construcao.model.Orcamento;
import com.etapa7e8.construcao.model.Venda;
import com.etapa7e8.construcao.service.OrcamentoService;
import com.etapa7e8.construcao.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private OrcamentoService orcamentoService;

    @Autowired
    private VendaService vendaService;

    // Exibir a página de venda
    @GetMapping("/nova-venda")
    public String novaVenda() {
        return "paginaVenda"; // Nome do template para venda
    }

    // Buscar orçamento pelo CPF do cliente
   /* @PostMapping("/buscar-orcamento")
    public String buscarOrcamento(@RequestParam("cpfCliente") String cpfCliente, Model model) {
        try {
            // Verificar se o método buscarPorCpfCliente existe e está implementado corretamente
            List<Orcamento> orcamentos = orcamentoService.buscarOrcamentosPorCpfCliente(cpfCliente);
            if (orcamentos.isEmpty()) {
                model.addAttribute("mensagemErro", "Nenhum orçamento encontrado para o CPF fornecido.");
                return "paginaVenda";
            }

            double total = orcamentos.stream()
                                     .mapToDouble(o -> o.getEstoque().getValorVenda() * o.getQuantidadeOrcamento())
                                     .sum();
            model.addAttribute("orcamentos", orcamentos);
            model.addAttribute("totalVenda", total);
            return "paginaVenda";
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "paginaVenda";
        }
    }*/

    // Realizar o pagamento da venda
    @PostMapping("/pagar")
    public String pagarVenda(@RequestParam("cpfCliente") String cpfCliente,
                             @RequestParam("vendedor") String vendedor,
                             @RequestParam("formaPagamento") String formaPagamento,
                             Model model) {
       /* try {
            // Buscar orçamentos do cliente
            List<Orcamento> orcamentos = orcamentoService.buscarOrcamentosPorCpfCliente(cpfCliente);
            if (orcamentos.isEmpty()) {
                model.addAttribute("mensagemErro", "Nenhum orçamento encontrado para o CPF fornecido.");
                return "paginaVenda";
            }

            double total = orcamentos.stream()
                                     .mapToDouble(o -> o.getEstoque().getValorVenda() * o.getQuantidadeOrcamento())
                                     .sum();

            // Criar a venda
            Venda venda = new Venda();
            venda.setFormaPagamento(formaPagamento);
            venda.setValorPago(total);
            vendaService.salvarVenda(venda);

            // Atualizar os orçamentos com a venda realizada
            for (Orcamento orcamento : orcamentos) {
                orcamento.setVenda(venda);
                orcamentoService.salvarOrcamento(orcamento);
            }

            model.addAttribute("mensagemSucesso", "Venda realizada com sucesso!");
            model.addAttribute("totalVenda", total);
            return "paginaVenda";
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "paginaVenda";
        }*/
       return "paginaVenda";//NAO ESQUECA DE CORRIGIR O METODO
    }
}