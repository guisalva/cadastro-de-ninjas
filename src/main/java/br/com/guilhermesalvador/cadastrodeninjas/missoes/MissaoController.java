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
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missaoService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public MissaoModel alterarMissao(@PathVariable Long id, @RequestBody MissaoModel missao) {
        return missaoService.atualizarMissao(id, missao);
    }

    @DeleteMapping
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }

}
