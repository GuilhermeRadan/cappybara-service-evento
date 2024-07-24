package com.br.cappybaramicroserviceevento.service;

import com.br.cappybaramicroserviceevento.dto.*;
import com.br.cappybaramicroserviceevento.model.CaminhoImagem;
import com.br.cappybaramicroserviceevento.model.CategoriaEvento;
import com.br.cappybaramicroserviceevento.model.Evento;
import com.br.cappybaramicroserviceevento.repository.CaminhoImagemRepository;
import com.br.cappybaramicroserviceevento.repository.CategoriaEventoRepository;
import com.br.cappybaramicroserviceevento.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
import java.util.Map;
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
        Evento evento = new Evento();

        Optional<CategoriaEvento> categoriaEvento = categoriaEventoRepository.findById(eventoCadastroDTO.getCategoriaEvento());
        categoriaEvento.ifPresent(evento::setCategoriaEvento);

        evento.setTitulo(eventoCadastroDTO.getTitulo());
        evento.setDescricao(eventoCadastroDTO.getDescricao());
        evento.setDataHoraInicio(eventoCadastroDTO.getDataHoraInicio());
        evento.setDataHoraTermino(eventoCadastroDTO.getDataHoraTermino());
        evento.setLatitude(eventoCadastroDTO.getLatitude());
        evento.setLongitude(eventoCadastroDTO.getLongitude());
        evento.setPreco(eventoCadastroDTO.getPreco());
        evento.setArtistas(eventoCadastroDTO.getArtistas());
        var eventoSalvo =eventoRepository.save(evento);

        caminhoImagemService.uploadImagens(imagens,eventoSalvo);
        return eventoSalvo;

    }

    public EventoDTO listarEventoPorId(Long id){
        Optional<Evento> busca = eventoRepository.findById(id);
        if (busca.isPresent()){
            var resultado = toDTO(busca.get());
            return resultado;
        }

        return null;
    }

    public List<EventoDTO> listarPorCategoriaId(Long id){
        List<Evento> listar = eventoRepository.findEventoByCategoriaEvento_Id(id);
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
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataAmanha() {
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataAmanha = dataHoje.plusDays(1);
        List<Evento> eventos = eventoRepository.findEventosByDataAmanha(dataAmanha);
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataSemana() {
        LocalDate dataHoje = LocalDate.now();
        LocalDate data7dias = dataHoje.plusDays(6);
        List<Evento> eventos = eventoRepository.findEventosByDataSemana(dataHoje, data7dias);
        return eventos.stream()
                .map(this::convertToEventoResumoDto)
                .collect(Collectors.toList());
    }

    public List<EventoResumoDTO> listarPorDataCalendario(LocalDate data){
        List<Evento> eventos = eventoRepository.findEventosByCalendario(data);
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
        dtoResumida.setDescricao(evento.getDescricao());
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


   /* public EventoDTO atualizacaoEvento(Long id, EventoAtualizacaoDTO eventoAtualizacaoDTO) {
        Optional<Evento> optionalEvento = eventoRepository.findById(id);
        if (optionalEvento.isPresent()){
            Evento eventoExistente = optionalEvento.get();
            BeanUtils.copyProperties(eventoAtualizacaoDTO, eventoExistente, );
        }
    }*/
}
