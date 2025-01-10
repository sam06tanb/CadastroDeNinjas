package dev.java10x.cadastrodeninja.Missoes.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastroMissoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "missoes") //uma missao pode ter varios ninjas
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
