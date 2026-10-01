package br.com.luisfillipe.vagas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "vagas")
public class Vaga {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank private String titulo;
    @NotBlank private String empresa;
    @NotBlank private String tecnologia;
    @NotBlank private String modalidade;
    private String localizacao;
    private String descricao;
    public Long getId(){return id;} public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
    public String getEmpresa(){return empresa;} public void setEmpresa(String v){empresa=v;}
    public String getTecnologia(){return tecnologia;} public void setTecnologia(String v){tecnologia=v;}
    public String getModalidade(){return modalidade;} public void setModalidade(String v){modalidade=v;}
    public String getLocalizacao(){return localizacao;} public void setLocalizacao(String v){localizacao=v;}
    public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
}