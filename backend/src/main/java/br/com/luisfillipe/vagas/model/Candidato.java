package br.com.luisfillipe.vagas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "candidatos")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    private String curso;
    private Integer periodo;

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public Integer getPeriodo() { return periodo; }
    public void setPeriodo(Integer periodo) { this.periodo = periodo; }
}