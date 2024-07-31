package com.br.cappybaramicroserviceevento.repository;



import com.br.cappybaramicroserviceevento.model.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    Page<Evento> findAll (Pageable pageable);
    List<Evento> findEventoByCategoriaEvento_Id(Long id);

    List<Evento> findEventosByCategoriaEvento_IdIn(List<Long> ids);

    List<Evento> findEventosByPrecoBetween(BigDecimal precoInicial, BigDecimal precoFinal);

    @Query("SELECT e FROM Evento e WHERE DATE(e.dataHoraInicio) = :dataHoje")
    List<Evento> findEventosByDataHoje(@Param("dataHoje")LocalDate dataHoje );

    @Query("SELECT e FROM Evento e WHERE DATE(e.dataHoraInicio) = :dataAmanha")
    List<Evento> findEventosByDataAmanha(@Param("dataAmanha")LocalDate dataAmanha );

    @Query("SELECT e FROM Evento e WHERE DATE(e.dataHoraInicio) BETWEEN  :dataHoje AND :data7dias")
    List<Evento> findEventosByDataSemana(@Param("dataHoje")LocalDate dataHoje, @Param("data7dias") LocalDate data7dias);
    @Query("SELECT e FROM Evento e WHERE DATE(e.dataHoraInicio) = :data")
    List<Evento> findEventosByCalendario(@Param("data")LocalDate data);

    @Query("SELECT e FROM Evento e WHERE (6371 * acos(cos(radians(:latitude)) * cos(radians(e.latitude)) * cos(radians(e.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(e.latitude)))) < :raioEmKm")
    Page<Evento> findEventosByLocalizacao(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("raioEmKm") Double raioEmKm, Pageable pageable);

}
