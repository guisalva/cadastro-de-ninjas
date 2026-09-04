package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDescricao(missaoDTO.getDescricao());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();

        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDescricao(missaoModel.getDescricao());
        missaoDTO.setNinjas(missaoModel.getNinjas());

        return missaoDTO;
    }
}
