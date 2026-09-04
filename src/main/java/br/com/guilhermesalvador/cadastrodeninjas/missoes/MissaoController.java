package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/criar")
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO) {
        return missaoService.criarMissao(missaoDTO);
    }

    @GetMapping("/listar")
    public List<MissaoDTO> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        return missaoService.atualizarMissao(id, missaoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissao(id);
    }

}
