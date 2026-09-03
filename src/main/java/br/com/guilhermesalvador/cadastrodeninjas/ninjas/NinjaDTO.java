package br.com.guilhermesalvador.cadastrodeninjas.ninjas;

import br.com.guilhermesalvador.cadastrodeninjas.missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private String rank;
    private int idade;
    private MissaoModel missao;

}
