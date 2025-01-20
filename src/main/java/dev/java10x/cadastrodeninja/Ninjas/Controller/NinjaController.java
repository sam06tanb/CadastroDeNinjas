package dev.java10x.cadastrodeninja.Ninjas.Controller;

import dev.java10x.cadastrodeninja.Ninjas.DTOMAPPER.NinjaDTO;
import dev.java10x.cadastrodeninja.Ninjas.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @PostMapping("/criar")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.adicionarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    @GetMapping("/mostrar")
    public ResponseEntity <List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaDTO ninjaPorID = ninjaService.listarNinjasPorID(id);
        if (ninjaPorID != null) {
            return ResponseEntity.ok(ninjaPorID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + id + "nao foi encontrado");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjasID(@PathVariable Long id, @RequestBody NinjaDTO ninja) {

        NinjaDTO ninjaAlterado = ninjaService.atualizarNinja(id, ninja);

        if (ninjaAlterado != null) {
            return ResponseEntity.ok("Ninja alterado com sucesso" + ninjaAlterado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + id + "nao foi encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> DeletarNinjasID(@PathVariable Long id) {
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deleteNinjaById(id);
            return ResponseEntity.ok("Ninja deletado com sucesso: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + id + "nao encontrado");
        }
    }

}
