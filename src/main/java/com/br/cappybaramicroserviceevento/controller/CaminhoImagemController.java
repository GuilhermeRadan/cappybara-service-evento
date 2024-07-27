package com.br.cappybaramicroserviceevento.controller;

import com.br.cappybaramicroserviceevento.service.CaminhoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/imagem")

public class CaminhoImagemController {



    private CaminhoImagemService caminhoImagemService;
    @Autowired
    public CaminhoImagemController(CaminhoImagemService caminhoImagemService){
        this.caminhoImagemService = caminhoImagemService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "cadastrar")
    public ResponseEntity popularImagens(@RequestParam("idEvento") Long idEvento, @RequestParam("imagens") List<MultipartFile> imagens) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED).body(caminhoImagemService.popularBanco(idEvento , imagens));
    }



}


