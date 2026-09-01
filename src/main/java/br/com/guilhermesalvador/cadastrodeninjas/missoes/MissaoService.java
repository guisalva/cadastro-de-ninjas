package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    // Criar Missão
    public MissaoModel criarMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    // Listar todas as missões
    public List<MissaoModel> listarMissoes() {
        return missaoRepository.findAll();
    }

    // Listar missão por ID
    public MissaoModel listarMissaoPorId(Long id) {
        return missaoRepository.findById(id).orElse(null);
    }

    public MissaoModel atualizarMissao(Long id, MissaoModel missao) {
        if (missaoRepository.existsById(id)) {
            missao.setId(id);
            return missaoRepository.save(missao);
        }

        return null;
    }

}
