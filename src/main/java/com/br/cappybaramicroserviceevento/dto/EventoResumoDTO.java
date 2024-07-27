package com.br.cappybaramicroserviceevento.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EventoResumoDTO {
    private Long id;

    private String titulo;

   private Double latitude;

   private Double longitude;

   private LocalDateTime dataHoraInicio;

    private List<String> urlImagem;

    public EventoResumoDTO(){}

    public EventoResumoDTO(Long id, String titulo, Double latitude, Double longitude, LocalDateTime dataHoraInicio, List<String> urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dataHoraInicio = dataHoraInicio;
        this.urlImagem = urlImagem;
    }



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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }
}
