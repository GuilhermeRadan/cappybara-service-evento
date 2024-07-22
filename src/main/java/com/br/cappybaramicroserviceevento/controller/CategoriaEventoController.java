package com.br.cappybaramicroserviceevento.controller;

import com.br.cappybaramicroserviceevento.dto.CategoriaEventoDTO;
import com.br.cappybaramicroserviceevento.service.CategoriaEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaEventoController {

    private CategoriaEventoService categoriaEventoService;

    @Autowired
    public CategoriaEventoController(CategoriaEventoService categoriaEventoService) {
        this.categoriaEventoService = categoriaEventoService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarCategoriaEvento(@RequestBody CategoriaEventoDTO categoriaEventoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaEventoService.cadastrar(categoriaEventoDto));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar")
    public List<CategoriaEventoDTO> listarCategoriaEvento() {
        return categoriaEventoService.listarCategoria();
    }
}
