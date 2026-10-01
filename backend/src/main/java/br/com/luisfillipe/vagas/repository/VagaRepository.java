package br.com.luisfillipe.vagas.repository;

import br.com.luisfillipe.vagas.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByTecnologiaContainingIgnoreCase(String tecnologia);
    List<Vaga> findByModalidadeIgnoreCase(String modalidade);
}