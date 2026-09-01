package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.web.bind.annotation.*;

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
    public String listarMissoes() {
        return "Missoes listadas com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }

}
