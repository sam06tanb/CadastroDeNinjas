package dev.java10x.cadastrodeninja.Missoes.Repository;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}
