package com.br.cappybaramicroserviceevento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

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

    public ArtistaEvento() {
    }

    public ArtistaEvento(Long id, String nomeArtista, Evento evento) {
        this.id = id;
        this.nomeArtista = nomeArtista;
        this.evento = evento;
    }

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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
