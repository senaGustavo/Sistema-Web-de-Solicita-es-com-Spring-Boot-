
package com.projeto.solicitacoes.controller;

import com.projeto.solicitacoes.model.Solicitacao;
import com.projeto.solicitacoes.service.SolicitacaoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SolicitacaoController {

    private final SolicitacaoService service;

    // Injeção pelo construtor
    public SolicitacaoController(SolicitacaoService service) {
        this.service = service;
    }

    // Formulário de cadastro
    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("solicitacao", new Solicitacao());
        return "formulario";
    }

    // Salvar cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Solicitacao solicitacao) {
        service.cadastrar(solicitacao);
        return "redirect:/lista";
    }

    // Listar todas
    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("solicitacoes", service.listarTodas());
        return "lista";
    }

    // Detalhes de uma solicitação
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("solicitacao", service.buscarPorId(id));
        return "detalhes";
    }

    // Alterar status
    @PostMapping("/status/{id}")
    public String alterarStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        service.alterarStatus(id, status);
        return "redirect:/detalhes/" + id;
    }
}
