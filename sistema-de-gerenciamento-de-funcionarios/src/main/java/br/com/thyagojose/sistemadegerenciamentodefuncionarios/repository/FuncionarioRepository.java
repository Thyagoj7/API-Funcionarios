package br.com.thyagojose.sistemadegerenciamentodefuncionarios.repository;

import br.com.thyagojose.sistemadegerenciamentodefuncionarios.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,UUID> {

    boolean existsBynome(String nome);
}




