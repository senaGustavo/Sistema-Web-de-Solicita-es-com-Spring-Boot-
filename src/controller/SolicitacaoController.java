package controller;

import model.Solicitacao;
import service.SolicitacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SolicitacaoController {

    private final SolicitacaoService service;

    // injeção pelo construtor
    public SolicitacaoController(SolicitacaoService service) {
        this.service = service;
    }

    // formulário de cadastro
    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("solicitacao", new Solicitacao());
        return "formulario";
    }

    // salvar cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Solicitacao solicitacao) {
        service.cadastrar(solicitacao);
        return "redirect:/lista";
    }

    // listar todas
    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("solicitacoes", service.listarTodas());
        return "lista";
    }

    // detalhes de uma
    @GetMapping("/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        model.addAttribute("solicitacao", service.buscarPorId(id));
        return "detalhes";
    }

    // alterar status
    @PostMapping("/status/{id}")
    public String alterarStatus(@PathVariable Long id,
                                @RequestParam String status) {
        service.alterarStatus(id, status);
        return "redirect:/detalhes/" + id;
    }
}