
package com.etapa7e8.construcao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Mapeamento para a página inicial
    @GetMapping("/pagina_inicial")
    public String showHomePage() {
        return "pagina_inicial";  // Nome do arquivo HTML da página inicial
    }

    // Mapeamento para exibir a página de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Nome da página HTML para o login
    }

    // Mapeamento para processar o formulário de login
    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario,
                        @RequestParam("senha") String senha,
                        Model model) {
        // Lógica de autenticação (simples, sem back-end)
        if (usuario.equals("usuario123") && senha.equals("1234")) {
            return "redirect:/pagina_inicial";  // Redireciona após login bem-sucedido
        } else {
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "login";  // Retorna à página de login com mensagem de erro
        }
    }
}