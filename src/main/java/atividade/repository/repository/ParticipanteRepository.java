package atividade.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Atividade.Atividade.model.Participante;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
