package atividade.controller;

import com.example.Atividade.Reuniao;
import atividade.service.ReuniaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reunioes")
public class ReuniaoController {
    @Autowired
    private ReuniaoService reuniaoService;

    @PostMapping
    public ResponseEntity<Reuniao> criarReuniao(@RequestBody Reuniao reuniao) {
        Reuniao novaReuniao = reuniaoService.criarReuniao(reuniao);
        return ResponseEntity.ok(novaReuniao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reuniao> buscarReuniao(@PathVariable Long id) {
        return reuniaoService.buscarReuniaoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reuniao> atualizarReuniao(@PathVariable Long id, @RequestBody Reuniao reuniao) {
        reuniao.setId(id);
        reuniaoService.atualizarReuniao(reuniao);
        return ResponseEntity.ok(reuniao);
    }


}
