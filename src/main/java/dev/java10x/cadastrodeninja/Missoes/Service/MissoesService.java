package dev.java10x.cadastrodeninja.Missoes.Service;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import dev.java10x.cadastrodeninja.Missoes.Repository.MissoesRepository;
import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> mostrar() {
        return missoesRepository.findAll();
    }

    public MissoesModel mostrarPorID(Long id) {
        Optional<MissoesModel> MostrarPorID = missoesRepository.findById(id);
        return MostrarPorID.orElse(null);
    }

    public MissoesModel adicionarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    public void deleteMissionById(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missao) {
        if (missoesRepository.existsById(id)) {
            missao.setId(id);
            return missoesRepository.save(missao);
        }
        return null;


    }
}
