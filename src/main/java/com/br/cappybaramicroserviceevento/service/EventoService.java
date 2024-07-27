package com.br.cappybaramicroserviceevento.service;

import com.br.cappybaramicroserviceevento.dto.*;
import com.br.cappybaramicroserviceevento.exceptions.CategoriaIdNotFoundException;
import com.br.cappybaramicroserviceevento.exceptions.EventIdNotFoundException;
import com.br.cappybaramicroserviceevento.exceptions.EventoNotFoundException;
import com.br.cappybaramicroserviceevento.model.CaminhoImagem;
import com.br.cappybaramicroserviceevento.model.CategoriaEvento;
import com.br.cappybaramicroserviceevento.model.Evento;
import com.br.cappybaramicroserviceevento.repository.CaminhoImagemRepository;
import com.br.cappybaramicroserviceevento.repository.CategoriaEventoRepository;
import com.br.cappybaramicroserviceevento.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoService {
    private final CategoriaEventoRepository categoriaEventoRepository;
    private final EventoRepository eventoRepository;
    private final CaminhoImagemService caminhoImagemService;

    private final CaminhoImagemRepository caminhoImagemRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public EventoService(EventoRepository eventoRepository, CategoriaEventoRepository categoriaEventoRepository,CaminhoImagemService caminhoImagemService, CaminhoImagemRepository caminhoImagemRepository,  ModelMapper modelMapper){
        this.eventoRepository = eventoRepository;
        this.categoriaEventoRepository = categoriaEventoRepository;
        this.caminhoImagemService = caminhoImagemService;
        this.caminhoImagemRepository = caminhoImagemRepository;
        this.modelMapper = modelMapper;

    }

    @Transactional
    public Evento cadastrar(EventoCadastroDTO eventoCadastroDTO, List<MultipartFile> imagens) throws IOException {

        Optional<CategoriaEvento> categoriaEvento = categoriaEventoRepository.findById(eventoCadastroDTO.getCategoriaEvento());
        if (categoriaEvento.isEmpty()){
            throw new CategoriaIdNotFoundException("Id categoria não encontrado");
        }

        Evento evento = converToEvento(eventoCadastroDTO, categoriaEvento.get());
        var eventoSalvo = eventoRepository.save(evento);

        caminhoImagemService.uploadImagens(imagens,eventoSalvo);
        return eventoSalvo;

    }

    public EventoDTO listarEventoPorId(Long id){
        Optional<Evento> busca = eventoRepository.findById(id);
        if (busca.isPresent()){
            return toDTO(busca.get());

        }
        throw new EventIdNotFoundException("Id do evento: " + id + ", não encontrado!");

    }

    public List<EventoDTO> listarPorCategoriaId(Long id){
        List<Evento> listar = eventoRepository.findEventoByCategoriaEvento_Id(id);
        if(listar.isEmpty()){
            throw new CategoriaIdNotFoundException("Id categoria não encontrado", id);
        }
        return listar.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }



    public List<EventoDTO> listarEventos(){
        List<Evento> eventos = eventoRepository.findAll();


        return eventos.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarResumoEvento(int pagina, int itens){
        Pageable pageable = PageRequest.of(pagina, itens);
        Page<Evento> eventos = eventoRepository.findAll(pageable);
        if(eventos.isEmpty()){
            throw new EventoNotFoundException("Eventos não encontrados !");
        }

        for (Evento e: eventos){
            List<String> urlRecebidas = new ArrayList<>();
            List<CaminhoImagem> caminhoImagem = caminhoImagemRepository.findCaminhoImagemByIdEvento(e);
            for (CaminhoImagem c: caminhoImagem){
                urlRecebidas.add(c.getUrl());
            }

        }

        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());

    }

    public List<EventoResumoDTO> listarPorFaixaDePreco(BigDecimal precoInicial, BigDecimal precoFinal) {
        List<Evento> eventos = eventoRepository.findEventosByPrecoBetween(precoInicial, precoFinal);
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataHoje() {
        List<Evento> eventos = eventoRepository.findEventosByDataHoje(LocalDate.now());
        if(eventos.isEmpty()){
            throw new EventoNotFoundException("Não existe evento para hoje !");
        }
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataAmanha() {
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataAmanha = dataHoje.plusDays(1);
        List<Evento> eventos = eventoRepository.findEventosByDataAmanha(dataAmanha);
        if(eventos.isEmpty()){
            throw new EventoNotFoundException("Não existe evento para amanhã !");
        }
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataSemana() {
        LocalDate dataHoje = LocalDate.now();
        LocalDate data7dias = dataHoje.plusDays(6);
        List<Evento> eventos = eventoRepository.findEventosByDataSemana(dataHoje, data7dias);
        if(eventos.isEmpty()){
            throw new EventoNotFoundException("Não existe evento para essa semana !");
        }
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataCalendario(LocalDate data){
        List<Evento> eventos = eventoRepository.findEventosByCalendario(data);
        if(eventos.isEmpty()){
            throw new EventoNotFoundException("Não existe evento para essa data!");
        }
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorRaioKm(Double latitude, Double longitude, Double raioEmKm) {
        List<Evento> eventos = eventoRepository.findEventosByLocalizacao(latitude, longitude, raioEmKm);
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public EventoTituloDTO convertToEventoTituloDTO(Evento evento){
        return modelMapper.map(evento, EventoTituloDTO.class);
    }
    public Evento converToEvento(EventoCadastroDTO eventoCadastroDTO, CategoriaEvento categoriaEvento){
        Evento evento = modelMapper.map(eventoCadastroDTO, Evento.class);
        evento.setCategoriaEvento(categoriaEvento);
        return evento;

    }


    private EventoResumoDTO convertToEventoResumoDto(Evento evento) {
        EventoResumoDTO dtoResumida = new EventoResumoDTO();

        List<CaminhoImagem> caminhoImagens = caminhoImagemRepository.findCaminhoImagemByIdEvento(evento);
        List<String> urlSeparada = new ArrayList<>();
        //separa a uri da classe CaminhoImagem
        for (var url : caminhoImagens){
            urlSeparada.add(url.getUrl());

        }
        dtoResumida.setId(evento.getId());
        dtoResumida.setTitulo(evento.getTitulo());
        dtoResumida.setDataHoraInicio(evento.getDataHoraInicio());
        dtoResumida.setLatitude(evento.getLatitude());
        dtoResumida.setLongitude(evento.getLongitude());
        dtoResumida.setUrlImagem(urlSeparada);


        return dtoResumida;
    }

    private EventoDTO toDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();

        List<CaminhoImagem> caminhoImagens = caminhoImagemRepository.findCaminhoImagemByIdEvento(evento);
        List<String> urlSeparada = new ArrayList<>();
        //separa a uri da classe CaminhoImagem
        for (var url : caminhoImagens){
            urlSeparada.add(url.getUrl());

        }
        dto.setImagens(urlSeparada);
        dto.setTitulo(evento.getTitulo());
        dto.setDescricao(evento.getDescricao());
        dto.setDataHoraInicio(evento.getDataHoraInicio());
        dto.setDataHoraTermino(evento.getDataHoraTermino());
        dto.setLatitude(evento.getLatitude());
        dto.setLongitude(evento.getLongitude());
        dto.setCategoriaEvento(evento.getCategoriaEvento().getId());
        dto.setArtistas(evento.getArtistas());

        dto.setPreco(evento.getPreco());


        return dto;

    }

}
