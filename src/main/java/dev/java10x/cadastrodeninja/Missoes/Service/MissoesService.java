package dev.java10x.cadastrodeninja.Missoes.Service;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import dev.java10x.cadastrodeninja.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

   public MissoesService(MissoesRepository missoesRepository) {
       this.missoesRepository = missoesRepository;
   }

   public List<MissoesModel> mostrar(){
      return missoesRepository.findAll();
   }

    public MissoesModel mostrarPorID(Long id){
        Optional<MissoesModel> MostrarPorID = missoesRepository.findById(id);
        return MostrarPorID.orElse(null);
    }



}
