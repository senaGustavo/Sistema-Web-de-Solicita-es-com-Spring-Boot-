package service;

import model.Solicitacao;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitacaoService {

    private final List<Solicitacao> lista = new ArrayList<>();
    private long proximoId = 1;

    public Solicitacao cadastrar(Solicitacao s) {
        s.setId(proximoId++);
        s.setStatus("Aberta"); // toda nova começa Aberta
        lista.add(s);
        return s;
    }

    public List<Solicitacao> listarTodas() {
        return lista;
    }

    public Solicitacao buscarPorId(Long id) {
        return lista.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void alterarStatus(Long id, String novoStatus) {
        Solicitacao s = buscarPorId(id);
        if (s != null) {
            s.setStatus(novoStatus);
        }
    }
}