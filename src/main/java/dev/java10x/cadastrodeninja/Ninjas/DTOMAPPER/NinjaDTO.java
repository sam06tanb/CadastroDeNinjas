package dev.java10x.cadastrodeninja.Ninjas.DTOMAPPER;
import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
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
        private int idade;
        private String rank;
        private MissoesModel missoes;


    }


