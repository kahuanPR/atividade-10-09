package atividade.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Atividade.Atividade.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
