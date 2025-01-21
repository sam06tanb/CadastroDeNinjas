package dev.java10x.cadastrodeninja.Missoes.Service;

import dev.java10x.cadastrodeninja.Missoes.DTOMAPPERMISSOES.MissoesDTO;
import dev.java10x.cadastrodeninja.Missoes.DTOMAPPERMISSOES.MissoesMAPPER;
import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import dev.java10x.cadastrodeninja.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMAPPER missoesMAPPER;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
        this.missoesMAPPER = new MissoesMAPPER();

    }

    public List<MissoesDTO> mostrar() {
         List<MissoesModel> missoes = missoesRepository.findAll();
         return missoes.stream()
                 .map(missoesMAPPER::map)
                 .collect(Collectors.toList());
    }

    public MissoesDTO mostrarPorID(Long id) {
        Optional<MissoesModel> MostrarPorID = missoesRepository.findById(id);
        return MostrarPorID.map(missoesMAPPER::map).orElse(null);
    }

    public MissoesDTO adicionarMissao(MissoesDTO missaoDTO) {
        MissoesModel missoes = missoesMAPPER.map(missaoDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMAPPER.map(missoes);
    }

    public void deleteMissionById(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missaoDTO) {
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        if (missoes.isPresent()) {
            MissoesModel missaoAtualizada = missoesMAPPER.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada) ;
            return missoesMAPPER.map(missaoSalva);
        }
        return null;
    }
}
