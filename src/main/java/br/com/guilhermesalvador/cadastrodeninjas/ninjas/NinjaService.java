package br.com.guilhermesalvador.cadastrodeninjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar os ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninja por ID
    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElse(null);
    }

    // Criar um novo Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Deletar um Ninja
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar um Ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizado) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);

        if (ninjaExistente.isPresent()) {
            NinjaModel ninja = ninjaMapper.map(ninjaAtualizado);
            ninja.setId(id);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
        }

        return null;
    }
}
