package com.br.cappybaramicroserviceevento.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Entity
@NoArgsConstructor
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

}
