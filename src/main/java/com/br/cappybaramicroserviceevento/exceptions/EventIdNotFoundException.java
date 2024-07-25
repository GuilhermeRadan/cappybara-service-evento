package com.br.cappybaramicroserviceevento.exceptions;

public class EventIdNotFoundException extends RuntimeException{



    public EventIdNotFoundException(){
        super("Evento não encontrado");
    }

    public EventIdNotFoundException(String message){
        super(message);
    }

}
