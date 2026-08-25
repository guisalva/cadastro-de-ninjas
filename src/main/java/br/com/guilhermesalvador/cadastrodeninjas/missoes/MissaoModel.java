package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import br.com.guilhermesalvador.cadastrodeninjas.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String descricao;

    private char rank;

    // @OneToMany - "uma" missão esta relacionada a "muitos" ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
