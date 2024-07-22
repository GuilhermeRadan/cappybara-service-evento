package com.br.cappybaramicroserviceevento.controller;

import com.br.cappybaramicroserviceevento.dto.EventoCadastroDTO;
import com.br.cappybaramicroserviceevento.dto.EventoDTO;
import com.br.cappybaramicroserviceevento.dto.EventoResumoDTO;
import com.br.cappybaramicroserviceevento.service.EventoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoService eventoService;

    private final ObjectMapper objectMapper;
    @Autowired
    public EventoController(EventoService eventoService, ObjectMapper objectMapper){
        this.eventoService = eventoService;
        this.objectMapper = objectMapper;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(value = "cadastrar")
    public ResponseEntity cadastrarEvento(@RequestParam("evento") String form, @RequestParam("imagens") List<MultipartFile> imagens) throws IOException {
        EventoCadastroDTO eventoCadastroDTO = objectMapper.readValue(form, EventoCadastroDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.cadastrar(eventoCadastroDTO , imagens));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar")
    public List<EventoDTO> listarEvento(){
        return eventoService.listarEventos();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listarPorId/{id}")
    public EventoDTO listarEventoPorId(@PathVariable Long id){
        return eventoService.listarEventoPorId(id);
    }



    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-faixa-preco")
    public List<EventoResumoDTO>listarPorFaixaDePreco(@RequestParam BigDecimal precoInicial, @RequestParam BigDecimal precoFinal ){
        return eventoService.listarPorFaixaDePreco(precoInicial, precoFinal);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-data-hoje")
    public List<EventoResumoDTO>listarPorDataHoje(){
        return eventoService.listarPorDataHoje();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-data-amanha")
    public List<EventoResumoDTO>listarPorDataAmanha(){
        return eventoService.listarPorDataAmanha();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-data-semana")
    public List<EventoResumoDTO>listarPorDataSemana(){
        return eventoService.listarPorDataSemana();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-data-calendario")
    public List<EventoResumoDTO>listarPorDataCalendario(@RequestParam LocalDate data){
        return eventoService.listarPorDataCalendario(data);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar-por-raio-km")
    public List<EventoResumoDTO>listarPorFaixaDePreco(@RequestParam Double latitude, @RequestParam Double longitude, Double raioEmKm ){
        return eventoService.listarPorRaioKm(latitude, longitude, raioEmKm);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listar-resumo-evento")
    public List<EventoResumoDTO>listarResumoEvento(){
        return eventoService.listarResumoEvento();
    }







    @CrossOrigin(origins = "*")
    @GetMapping("/listar/categoria-id/{id}")
    public List<EventoDTO> listarEventoPorCategoria(@PathVariable Long id){
        return eventoService.listarPorCategoriaId(id);
    }



    @GetMapping("/listar-evento-resumo")
    public List<EventoResumoDTO> listarEventoResumo(){
        return eventoService.listarResumoEvento();
    }


}
