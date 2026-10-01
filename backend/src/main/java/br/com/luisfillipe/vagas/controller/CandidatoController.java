package br.com.luisfillipe.vagas.controller;

import br.com.luisfillipe.vagas.model.Candidato;
import br.com.luisfillipe.vagas.repository.CandidatoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
@CrossOrigin(origins = "http://localhost:5173")
public class CandidatoController {

    private final CandidatoRepository repository;

    public CandidatoController(CandidatoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Candidato> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Candidato criar(@Valid @RequestBody Candidato candidato) {
        return repository.save(candidato);
    }
}