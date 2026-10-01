package br.com.luisfillipe.vagas.repository;

import br.com.luisfillipe.vagas.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}