package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import br.com.guilhermesalvador.cadastrodeninjas.ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private List<NinjaModel> ninjas;
}
