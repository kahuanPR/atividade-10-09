package atividade.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Atividade.Atividade.model.Reuniao;

import atividade.service.Reuniaoservice.ReuniaoService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reunioes")
public class ReuniaoController {

    @Autowired
    private ReuniaoService reuniaoService;


    @GetMapping("/index")
    public String index() {
        return "index"; // 
    }


    @GetMapping
    public String listarReunioes(Model model) {
        List<Reuniao> reunioes = reuniaoService.listarReunioes();
        model.addAttribute("reunioes", reunioes);
        return "listar-reunioes";  
    }

   
    @GetMapping("/novo")
    public String novoFormulario(Model model) {
     model.addAttribute("reuniao", new Reuniao());
        return "formulario-reuniao/index";  
    }

    // Salvar reunião (POST)
    @PostMapping("/salvar")
    public String salvarReuniao(@ModelAttribute Reuniao reuniao) {
        reuniaoService.criarReuniao(reuniao);
        return "redirect:/reunioes";
    }

    // Formulário para edição de reunião
    @GetMapping("/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        Optional<Reuniao> reuniao = reuniaoService.buscarReuniaoPorId(id);
        if (reuniao.isPresent()) {
            model.addAttribute("reuniao", reuniao.get());
            return "formulario-reuniao";  
        } else {
            return "redirect:/reunioes";
        }
    }
}
