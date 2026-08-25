package br.com.guilhermesalvador.cadastrodeninjas.ninjas;

import br.com.guilhermesalvador.cadastrodeninjas.missoes.MissaoModel;
import jakarta.persistence.*;

// Entity transforma uma classe em uma entidade do Banco de Dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    // @ManyToOne - "muitos" ninjas estao relacionados a "uma" missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreign Key
    private MissaoModel missao;


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
