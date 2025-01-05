package dev.java10x.cadastrodeninja.Ninjas.Model;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;
    private int idade;

    @ManyToOne //muitos ninjas podem estar na mesma missao
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
