package br.com.luisfillipe.vagas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidaturas")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Candidato candidato;

    @ManyToOne(optional = false)
    private Vaga vaga;

    @Enumerated(EnumType.STRING)
    private CandidaturaStatus status = CandidaturaStatus.ENVIADA;

    public Long getId() { return id; }
    public Candidato getCandidato() { return candidato; }
    public void setCandidato(Candidato candidato) { this.candidato = candidato; }
    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }
    public CandidaturaStatus getStatus() { return status; }
    public void setStatus(CandidaturaStatus status) { this.status = status; }
}