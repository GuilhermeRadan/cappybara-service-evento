package com.br.cappybaramicroserviceevento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
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

}
