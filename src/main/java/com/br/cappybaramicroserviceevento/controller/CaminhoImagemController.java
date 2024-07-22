package com.br.cappybaramicroserviceevento.controller;





import com.br.cappybaramicroserviceevento.service.CaminhoImagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/imagem")

public class CaminhoImagemController {



    private CaminhoImagemService caminhoImagemService;

    public CaminhoImagemController(CaminhoImagemService caminhoImagemService){
        this.caminhoImagemService = caminhoImagemService;
    }


   /* @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String fileName = caminhoImagemService.upload(file);
        return ResponseEntity.ok(fileName);
    }*/

}


