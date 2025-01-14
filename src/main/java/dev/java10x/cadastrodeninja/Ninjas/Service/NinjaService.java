package dev.java10x.cadastrodeninja.Ninjas.Service;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public NinjaModel adicionarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }
}
