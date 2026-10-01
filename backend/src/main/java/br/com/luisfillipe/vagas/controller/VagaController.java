package br.com.luisfillipe.vagas.controller;

import br.com.luisfillipe.vagas.model.Vaga;
import br.com.luisfillipe.vagas.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "http://localhost:5173")
public class VagaController {

    private final VagaRepository repository;

    public VagaController(VagaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Vaga> listar(
            @RequestParam(required = false) String tecnologia,
            @RequestParam(required = false) String modalidade) {

        if (tecnologia != null && !tecnologia.isBlank()) {
            return repository.findByTecnologiaContainingIgnoreCase(tecnologia);
        }

        if (modalidade != null && !modalidade.isBlank()) {
            return repository.findByModalidadeIgnoreCase(modalidade);
        }

        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vaga criar(@Valid @RequestBody Vaga vaga) {
        return repository.save(vaga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Vaga dados) {

        return repository.findById(id)
                .map(vaga -> {
                    vaga.setTitulo(dados.getTitulo());
                    vaga.setEmpresa(dados.getEmpresa());
                    vaga.setTecnologia(dados.getTecnologia());
                    vaga.setModalidade(dados.getModalidade());
                    vaga.setLocalizacao(dados.getLocalizacao());
                    vaga.setDescricao(dados.getDescricao());
                    return ResponseEntity.ok(repository.save(vaga));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}