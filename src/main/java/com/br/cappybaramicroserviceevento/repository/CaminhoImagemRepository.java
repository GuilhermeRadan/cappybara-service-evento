package com.br.cappybaramicroserviceevento.repository;

import com.br.cappybaramicroserviceevento.model.CaminhoImagem;
import com.br.cappybaramicroserviceevento.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaminhoImagemRepository extends JpaRepository<CaminhoImagem, Long> {

    public List<CaminhoImagem> findCaminhoImagemByIdEvento(Evento idEvento);
}
