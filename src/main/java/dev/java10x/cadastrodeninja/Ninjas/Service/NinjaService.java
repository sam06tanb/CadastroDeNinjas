package dev.java10x.cadastrodeninja.Ninjas.Service;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.DTOMAPPER.NinjaDTO;
import dev.java10x.cadastrodeninja.Ninjas.DTOMAPPER.NinjaMAPPER;
import dev.java10x.cadastrodeninja.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMAPPER ninjaMAPPER;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMAPPER = new NinjaMAPPER();
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMAPPER::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjasPorID(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMAPPER::map).orElse(null);
    }

    public NinjaDTO adicionarNinja(NinjaDTO NinjaDTO) {
        NinjaModel ninja = ninjaMAPPER.map(NinjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMAPPER.map(ninja);
    }

    public void deleteNinjaById(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMAPPER.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMAPPER.map(ninjaSalvo);
        }
        return null;
    }
}
