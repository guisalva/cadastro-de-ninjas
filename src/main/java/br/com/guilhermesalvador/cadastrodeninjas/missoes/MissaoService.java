package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.stereotype.Service;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

}
