package com.br.cappybaramicroserviceevento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_url_imagem")
public class CaminhoImagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento idEvento;

}
