package com.br.cappybaramicroserviceevento.exceptions;

public class EventoNotFoundException extends RuntimeException{

    public EventoNotFoundException(String message){
        super(message);
    }
}
