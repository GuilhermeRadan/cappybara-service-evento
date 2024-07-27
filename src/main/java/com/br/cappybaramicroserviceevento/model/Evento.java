package com.br.cappybaramicroserviceevento.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "tb_evento")
public class Evento  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;
    @Column(name = "data_hora_termino")
    private LocalDateTime dataHoraTermino;
    @Column
    private Double latitude;
    @Column
    private Double longitude;

    @ManyToOne()
    @JsonIgnoreProperties("evento")
    @JoinColumn(name = "id_categoria")
    private CategoriaEvento categoriaEvento;
    @Column
    private BigDecimal preco;
    @Column
    private String artistas;
    @OneToMany(mappedBy = "idEvento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CaminhoImagem> urlImagem = new HashSet<>();

    public Evento() {
    }

    public Evento(Long id, String titulo, String descricao, LocalDateTime dataHoraInicio, LocalDateTime dataHoraTermino, Double latitude, Double longitude, CategoriaEvento categoriaEvento, BigDecimal preco, String artistas, Set<CaminhoImagem> urlImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categoriaEvento = categoriaEvento;
        this.preco = preco;
        this.artistas = artistas;
        this.urlImagem = urlImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategoriaEvento getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
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

    public Set<CaminhoImagem> getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(Set<CaminhoImagem> urlImagem) {
        this.urlImagem = urlImagem;
    }
}
