package br.com.luisfillipe.vagas.repository;

import br.com.luisfillipe.vagas.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
}