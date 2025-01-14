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
    public NinjaModel adicionarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.adicionarNinja(ninja) ;
    }

    @GetMapping("/mostrar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/mostrar/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
    }

    @PutMapping("/alterarID")
    public String alterarNinjasID() {
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarNinjasID(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
