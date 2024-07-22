package com.br.cappybaramicroserviceevento.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_artista_evento")
public class ArtistaEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nm_artista")
    private String nomeArtista;
    @ManyToOne
    @JoinColumn(name = "id_Evento", nullable = false)
    private Evento evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
}
