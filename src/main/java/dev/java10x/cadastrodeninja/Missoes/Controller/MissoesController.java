package dev.java10x.cadastrodeninja.Missoes.Controller;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import dev.java10x.cadastrodeninja.Missoes.Service.MissoesService;
import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/mostrar")
    public List<MissoesModel> mostrar(){
        return missoesService.mostrar();
    }

    @GetMapping("/mostrar/{id}")
    public MissoesModel mostrar(@PathVariable Long id){
        return missoesService.mostrarPorID(id);
    }

    @PostMapping("/criarMissao")
    public MissoesModel adicionarMissao(@RequestBody MissoesModel missao) {
        return missoesService.adicionarMissao(missao);
    }

    @PutMapping("/alterarMissao/{id}")
    public MissoesModel alterarMissaoID(@PathVariable Long id, @RequestBody MissoesModel missao) {
        return missoesService.atualizarMissao(id, missao);
    }

    @DeleteMapping("/deletarMissao/{id}")
    public void DeletarMissaoID(@PathVariable Long id) {
        missoesService.deleteMissionById(id);
    }
}
