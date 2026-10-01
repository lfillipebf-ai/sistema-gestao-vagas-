package br.com.luisfillipe.vagas.controller;

import br.com.luisfillipe.vagas.model.Candidatura;
import br.com.luisfillipe.vagas.model.CandidaturaStatus;
import br.com.luisfillipe.vagas.repository.CandidaturaRepository;
import br.com.luisfillipe.vagas.repository.CandidatoRepository;
import br.com.luisfillipe.vagas.repository.VagaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidaturas")
@CrossOrigin(origins = "http://localhost:5173")
public class CandidaturaController {

    private final CandidaturaRepository candidaturaRepository;
    private final CandidatoRepository candidatoRepository;
    private final VagaRepository vagaRepository;

    public CandidaturaController(
            CandidaturaRepository candidaturaRepository,
            CandidatoRepository candidatoRepository,
            VagaRepository vagaRepository) {
        this.candidaturaRepository = candidaturaRepository;
        this.candidatoRepository = candidatoRepository;
        this.vagaRepository = vagaRepository;
    }

    @GetMapping
    public List<Candidatura> listar() {
        return candidaturaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Candidatura> criar(
            @RequestParam Long candidatoId,
            @RequestParam Long vagaId) {

        var candidato = candidatoRepository.findById(candidatoId);
        var vaga = vagaRepository.findById(vagaId);

        if (candidato.isEmpty() || vaga.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Candidatura candidatura = new Candidatura();
        candidatura.setCandidato(candidato.get());
        candidatura.setVaga(vaga.get());

        return ResponseEntity.ok(candidaturaRepository.save(candidatura));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Candidatura> atualizarStatus(
            @PathVariable Long id,
            @RequestParam CandidaturaStatus status) {

        return candidaturaRepository.findById(id)
                .map(candidatura -> {
                    candidatura.setStatus(status);
                    return ResponseEntity.ok(candidaturaRepository.save(candidatura));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}