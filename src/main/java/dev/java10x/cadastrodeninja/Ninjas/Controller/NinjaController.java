package dev.java10x.cadastrodeninja.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criado com sucesso!";
    }

    @GetMapping("/mostrar")
    public String mostrarNinjas() {
        return "Lista de Ninjas";
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
