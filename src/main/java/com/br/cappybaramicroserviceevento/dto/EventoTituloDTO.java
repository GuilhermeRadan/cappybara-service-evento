package com.br.cappybaramicroserviceevento.dto;

public class EventoTituloDTO {

    private String titulo;

    public EventoTituloDTO(){}

    public EventoTituloDTO (String titulo){
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
