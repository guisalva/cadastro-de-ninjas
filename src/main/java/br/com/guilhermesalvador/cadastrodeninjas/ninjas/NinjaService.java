package br.com.guilhermesalvador.cadastrodeninjas.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }
}
