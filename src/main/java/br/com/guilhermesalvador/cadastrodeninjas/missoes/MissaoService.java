package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import br.com.guilhermesalvador.cadastrodeninjas.ninjas.NinjaMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    // Criar Missão
    public MissaoDTO criarMissao(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);

        return missaoMapper.map(missao);
    }

    // Listar todas as missões
    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missoes = missaoRepository.findAll();

        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    // Listar missão por ID
    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);

        return missao.map(missaoMapper::map).orElse(null);
    }

    // Atualizar uma missão
    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO) {
        if (missaoRepository.findById(id).isPresent()) {
            MissaoModel missao = missaoMapper.map(missaoDTO);
            missao.setId(id);
            missao = missaoRepository.save(missao);

            return missaoMapper.map(missao);
        }

        return null;
    }

    // Deletar uma missão
    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }

}
