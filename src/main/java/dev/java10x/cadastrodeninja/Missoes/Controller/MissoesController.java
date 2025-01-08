package dev.java10x.cadastrodeninja.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/mostrar")
    public String mostrar(){
        return "Mostrando missoes";
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
