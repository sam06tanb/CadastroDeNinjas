package dev.java10x.cadastrodeninja.Ninjas.Repository;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
