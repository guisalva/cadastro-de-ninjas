package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

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

}
