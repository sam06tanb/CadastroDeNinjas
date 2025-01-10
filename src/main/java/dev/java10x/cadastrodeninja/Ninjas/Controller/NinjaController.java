package dev.java10x.cadastrodeninja.Ninjas.Controller;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criado com sucesso!";
    }

    @GetMapping("/mostrar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/mostrarID")
    public String mostrarNinjasID() {
        return "Lista de NinjasID";
    }

    @PutMapping("/alterarID")
    public String alterarNinjasID() {
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String DeletarNinjasID() {
        return "Deletado com sucesso!";
    }

}
