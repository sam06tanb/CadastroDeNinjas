package dev.java10x.cadastrodeninja.Missoes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissoesController {

    @GetMapping("/Missoes")
    public void Missoes() {
        System.out.println("Cadastro de missoes");
    }

}
