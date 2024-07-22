package com.br.cappybaramicroserviceevento.dto;

import java.util.List;

public class EventoResumoDTO {
    private Long id;


    private String titulo;

    private String descricao;

    private List<String> urlImagem;

    public EventoResumoDTO(Long id, String titulo, String descricao, List<String> urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
    }


    public EventoResumoDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(List<String> urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
