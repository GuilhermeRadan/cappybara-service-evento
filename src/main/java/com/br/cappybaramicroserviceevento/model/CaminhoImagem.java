package com.br.cappybaramicroserviceevento.model;

import jakarta.persistence.*;


import java.io.Serializable;
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
    public CaminhoImagem() {
    }
    public CaminhoImagem(Long id, String url, Evento idEvento) {
        this.id = id;
        this.url = url;
        this.idEvento = idEvento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }
}
