package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissaoDTO missaoDTO) {
        MissaoDTO novaMissao = missaoService.criarMissao(missaoDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Missao '" + novaMissao.getNome() + "' criada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listarMissoes();

        return  ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissaoDTO missao = missaoService.listarMissaoPorId(id);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID " + id + " não foi encontrada!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        MissaoDTO missao = missaoService.atualizarMissao(id, missaoDTO);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID " + id + " não foi encontrada!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (missaoService.listarMissaoPorId(id) != null) {
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missão de ID " + id + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão de ID " + id + " não foi encontrada!");
        }

    }

}
