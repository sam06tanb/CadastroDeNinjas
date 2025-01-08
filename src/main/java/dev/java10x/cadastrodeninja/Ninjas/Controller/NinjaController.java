package dev.java10x.cadastrodeninja.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @PostMapping("/criar")
    public String criarNinja() {
        return "Criado com sucesso!";
    }

    @GetMapping("/todos")
    public String mostrarNinjas() {
        return "Lista de Ninjas";
    }

    @GetMapping("/todosID")
    public String mostrarNinjasID() {
        return "Lista de NinjasID";
    }

    @PutMapping("/alterarID")
    public String alterarNinjasID() {
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/alterarID")
    public String DeletarNinjasID() {
        return "Deletado por ID com sucesso!";
    }

}
