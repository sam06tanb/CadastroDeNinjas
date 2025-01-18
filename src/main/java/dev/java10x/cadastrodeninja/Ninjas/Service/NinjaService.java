package dev.java10x.cadastrodeninja.Ninjas.Service;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.NinjaDTO;
import dev.java10x.cadastrodeninja.Ninjas.NinjaMAPPER;
import dev.java10x.cadastrodeninja.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMAPPER ninjaMAPPER;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMAPPER = new NinjaMAPPER();
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    public NinjaDTO adicionarNinja(NinjaDTO NinjaDTO) {
        NinjaModel ninja = ninjaMAPPER.map(NinjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMAPPER.map(ninja);
    }

    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;

    }
}
