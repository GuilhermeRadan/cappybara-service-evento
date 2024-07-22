package com.br.cappybaramicroserviceevento.dto;

public class CategoriaEventoDTO {

    private Long id;
    private String nome;

    public CategoriaEventoDTO(){}

    public CategoriaEventoDTO(String nome, Long id){
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
