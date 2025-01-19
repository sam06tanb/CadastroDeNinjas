package dev.java10x.cadastrodeninja.Ninjas.Controller;

import dev.java10x.cadastrodeninja.Ninjas.Model.NinjaModel;
import dev.java10x.cadastrodeninja.Ninjas.NinjaDTO;
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
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.adicionarNinja(ninja) ;
    }

    @GetMapping("/mostrar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/mostrar/{id}")
    public NinjaDTO listarNinjasPorID(@PathVariable Long id) {
        return ninjaService.listarNinjasPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasID(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarNinjasID(@PathVariable Long id) {
        ninjaService.deleteNinjaById(id);
    }

}
