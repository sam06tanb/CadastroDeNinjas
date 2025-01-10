package dev.java10x.cadastrodeninja.Ninjas.Service;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }
}
