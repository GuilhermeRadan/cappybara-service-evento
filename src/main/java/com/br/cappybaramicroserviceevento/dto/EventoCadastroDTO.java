package com.br.cappybaramicroserviceevento.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoCadastroDTO {
    private String titulo;
    private String descricao;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraTermino;

    private Double latitude;

    private Double longitude;

    private Long categoriaEvento;

    private BigDecimal preco;

    private String artistas;

    public EventoCadastroDTO(String titulo, String descricao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino, Double latitude, Double longitude, Long categoriaEvento, BigDecimal preco, String artistas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categoriaEvento = categoriaEvento;
        this.preco = preco;
        this.artistas = artistas;
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

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraTermino() {
        return dataHoraTermino;
    }

    public void setDataHoraTermino(LocalDateTime dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
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

    public Long getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(Long categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }
}
