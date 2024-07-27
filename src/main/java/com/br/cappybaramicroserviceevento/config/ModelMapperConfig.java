package com.br.cappybaramicroserviceevento.config;

import com.br.cappybaramicroserviceevento.dto.EventoCadastroDTO;
import com.br.cappybaramicroserviceevento.model.Evento;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ModelMapperConfig {

    @Bean
    public ModelMapper modalMapper(){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<EventoCadastroDTO, Evento>() {
            @Override
            protected void configure() {
                // Ignorando o mapeamento do atributo categoriaEvento que não está no DTO
                skip(destination.getCategoriaEvento());
            }
        });
        return modelMapper;
    }

}
