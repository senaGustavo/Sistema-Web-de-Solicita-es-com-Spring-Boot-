
package com.projeto.solicitacoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.solicitacoes.model.Solicitacao;

@Service
public class SolicitacaoService {

    private final List<Solicitacao> lista = new ArrayList<>();

    private Long proximoId = 1L;

    // Cadastrar solicitação
    public Solicitacao cadastrar(Solicitacao s) {
        s.setId(proximoId++);
        s.setStatus("Aberta");

        lista.add(s);

        return s;
    }

    // Listar todas as solicitações
    public List<Solicitacao> listarTodas() {
        return lista;
    }

    // Buscar solicitação pelo ID
    public Solicitacao buscarPorId(Long id) {
        return lista.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Alterar status da solicitação
    public void alterarStatus(Long id, String novoStatus) {
        Solicitacao s = buscarPorId(id);

        if (s != null) {
            s.setStatus(novoStatus);
        }
    }
}
