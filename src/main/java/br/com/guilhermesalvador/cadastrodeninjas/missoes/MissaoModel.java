package br.com.guilhermesalvador.cadastrodeninjas.missoes;

import br.com.guilhermesalvador.cadastrodeninjas.ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    // @OneToMany - "uma" missão esta relacionada a "muitos" ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
