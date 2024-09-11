package atividade.service;

import com.example.Atividade.Reuniao;
import atividade.repository.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReuniaoService {
    @Autowired
    private ReuniaoRepository reuniaoRepository;

    public Reuniao criarReuniao(Reuniao reuniao) {
        return reuniaoRepository.save(reuniao);
    }

    public Optional<Reuniao> buscarReuniaoPorId(Long id) {
        return reuniaoRepository.findById(id);
    }

    public void atualizarReuniao(Reuniao reuniao) {
        reuniaoRepository.save(reuniao);
    }

    public List<Reuniao> listarReunioes() {
        return reuniaoRepository.findAll();
    }
}
