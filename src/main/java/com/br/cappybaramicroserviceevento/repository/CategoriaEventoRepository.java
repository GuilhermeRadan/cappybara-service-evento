package com.br.cappybaramicroserviceevento.repository;




import com.br.cappybaramicroserviceevento.model.CategoriaEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {
}
