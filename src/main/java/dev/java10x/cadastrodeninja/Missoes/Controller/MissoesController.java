package dev.java10x.cadastrodeninja.Missoes.Controller;

import dev.java10x.cadastrodeninja.Missoes.Model.MissoesModel;
import dev.java10x.cadastrodeninja.Missoes.Service.MissoesService;
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

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Alterar";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Deletar";
    }
}
