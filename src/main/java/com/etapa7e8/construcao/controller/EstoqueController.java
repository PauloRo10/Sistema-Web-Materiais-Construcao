package com.etapa7e8.construcao.controller;

import com.etapa7e8.construcao.model.Estoque;
import com.etapa7e8.construcao.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Página para cadastrar produto
    @PostMapping("/cadastrar")
    public String cadastrarProduto(@ModelAttribute Estoque estoque, Model model) {
        estoqueService.salvarProduto(estoque);
        return "redirect:/estoque/listar";  // Redireciona para a lista após o cadastro
    }

    // Página inicial com o formulário de busca
    @GetMapping("/buscar")
    public String buscarProduto() {
        return "buscarProduto";  // Redireciona para a página de busca
    }

    // Resultado da busca por código e redirecionamento para edição
    @PostMapping("/buscar")
    public String resultadoBusca(@RequestParam("codigo") int codigo, Model model) {
        Optional<Estoque> produtoOpt = estoqueService.buscarPorCodigo(codigo);
        if (produtoOpt.isPresent()) {
            model.addAttribute("produto", produtoOpt.get());
            return "editarProduto";  // Redireciona para a página de edição se o produto for encontrado
        } else {
            model.addAttribute("mensagemErro", "Produto não encontrado.");
            return "buscarProduto";  // Retorna à página de busca com uma mensagem de erro
        }
    }
   // Atualizar o produto após a busca
    @PostMapping("/atualizar")
public String atualizarProduto(@ModelAttribute Estoque estoque, Model model) {
    // Verificar se o produto já existe pelo ID
    Optional<Estoque> produtoExistente = estoqueService.buscarPorId(estoque.getIdEstoque());

    if (produtoExistente.isPresent()) {
        Estoque produto = produtoExistente.get();
        
        // Atualizar os campos do produto existente
        produto.setProduto(estoque.getProduto());
        produto.setQuantidade(estoque.getQuantidade());
        produto.setMarca(estoque.getMarca());
        produto.setCnpj(estoque.getCnpj());
        produto.setValorEntrada(estoque.getValorEntrada());
        produto.setValorVenda(estoque.getValorVenda());
        produto.setDetalhes(estoque.getDetalhes());

        // Salvar as atualizações
        estoqueService.salvarProduto(produto);

        model.addAttribute("produto", produto);
        model.addAttribute("mensagemSucesso", "Produto atualizado com sucesso!");
    } else {
        model.addAttribute("mensagemErro", "Produto não encontrado para atualizar.");
    }

    return "editarProduto";  // Retorna para a página de edição com o produto atualizado
}
    // Entrada de produto
    @PostMapping("/entrada")
    public String entradaProduto(@RequestParam("codigo") int codigo, @RequestParam("quantidade") int quantidade, Model model) {
        try {
            Estoque produto = estoqueService.entradaProduto(codigo, quantidade);
            model.addAttribute("mensagemSucesso", "Entrada de produto realizada com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/estoque/listar";  // Redireciona para a lista após a entrada
    }

    // Saída de produto
    @PostMapping("/saida")
    public String saidaProduto(@RequestParam("codigo") int codigo, @RequestParam("quantidade") int quantidade, Model model) {
        try {
            Estoque produto = estoqueService.saidaProduto(codigo, quantidade);
            model.addAttribute("mensagemSucesso", "Saída de produto realizada com sucesso!");
        } catch (IllegalArgumentException e) {
            model.addAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/estoque/listar";  // Redireciona para a lista após a saída
    }

    // Listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        List<Estoque> produtos = estoqueService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "paginaEstoque";
    }

    // Excluir produto
   @GetMapping("/excluir")
public String excluirProduto(@RequestParam("codigo") int codigo, Model model) {
    estoqueService.excluirProduto(codigo);
    model.addAttribute("mensagemSucesso", "Produto excluído com sucesso!");
    return "redirect:/estoque/listar";  // Redireciona para a lista após exclusão
}
    @GetMapping("/pagina-busca")
public String mostrarPaginaBuscarProduto(Model model) {
    model.addAttribute("produto", new Estoque());  // Cria um novo objeto Estoque para o formulário
    return "buscarProduto";  
}

}