package dev.java10x.cadastrodeninja.Missoes.Controller;

import dev.java10x.cadastrodeninja.Missoes.DTOMAPPERMISSOES.MissoesDTO;

import dev.java10x.cadastrodeninja.Missoes.Service.MissoesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @Autowired
    private MissoesService missoesService;

    @GetMapping("/mostrar")
    public ResponseEntity<List<MissoesDTO>> mostrar() {
        List<MissoesDTO> missoes = missoesService.mostrar();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarPorID(@PathVariable Long id) {
        MissoesDTO missaoPorId = missoesService.mostrarPorID(id);
        if (missaoPorId != null) {
            return ResponseEntity.ok(missaoPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com o ID " + id + " Nao foi encontrada");
        }
    }

    @PostMapping("/criarMissao")
    public ResponseEntity<String> adicionarMissao(@RequestBody MissoesDTO missaoDTO) {
        MissoesDTO NovasMissoes = missoesService.adicionarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso: " + NovasMissoes.getNome() + "(ID): " + NovasMissoes.getId());
    }

    @PutMapping("/alterarMissao/{id}")
    public ResponseEntity<?> alterarMissaoID(@PathVariable Long id, @RequestBody MissoesDTO missaoDTO) {

        MissoesDTO missaoAlterada = missoesService.atualizarMissao(id, missaoDTO);

        if (missaoAlterada != null) {
            return ResponseEntity.ok("Missao alterada com sucesso" + missaoAlterada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o id: " + id + " Nao foi encontrada");
        }
    }


    @DeleteMapping("/deletarMissao/{id}")
    public ResponseEntity<String> DeletarMissaoID(@PathVariable Long id) {
        if (missoesService.mostrarPorID(id) != null) {
            missoesService.deleteMissionById(id);
            return ResponseEntity.ok("Missao deletada com sucesso!" + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A missao com o id " + id + " nao foi encontrada");
        }
    }
}
