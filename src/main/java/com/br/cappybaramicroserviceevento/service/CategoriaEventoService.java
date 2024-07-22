package com.br.cappybaramicroserviceevento.service;


import com.br.cappybaramicroserviceevento.dto.CategoriaEventoDTO;
import com.br.cappybaramicroserviceevento.model.CategoriaEvento;
import com.br.cappybaramicroserviceevento.repository.CategoriaEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaEventoService {

    private final CategoriaEventoRepository categoriaEventoRepository;
    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository){
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public CategoriaEvento cadastrar(CategoriaEventoDTO categoriaEventoDto){
        CategoriaEvento categoria = new CategoriaEvento();
        categoria.setNome(categoriaEventoDto.getNome());
        return categoriaEventoRepository.save(categoria);
    }

    public List<CategoriaEventoDTO> listarCategoria(){
        List<CategoriaEvento> categoriaEventos = categoriaEventoRepository.findAll();
        return categoriaEventos.stream().map(this::toDTO).collect(Collectors.toList());

    }

    public CategoriaEventoDTO toDTO(CategoriaEvento categoriaEvento){
        CategoriaEventoDTO categoriaDTO = new CategoriaEventoDTO();
        categoriaDTO.setNome(categoriaEvento.getNome());
        categoriaDTO.setId(categoriaEvento.getId());
        return categoriaDTO;
    }
}
