package com.br.cappybaramicroserviceevento.handler;

import com.br.cappybaramicroserviceevento.dto.exceptions.ErroDTO;
import com.br.cappybaramicroserviceevento.exceptions.CategoriaIdNotFoundException;
import com.br.cappybaramicroserviceevento.exceptions.EventIdNotFoundException;
import com.br.cappybaramicroserviceevento.exceptions.EventoNotFoundException;
import com.br.cappybaramicroserviceevento.exceptions.FaixaPrecoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
   @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(EventIdNotFoundException.class)
    private ErroDTO eventIdNotFound(EventIdNotFoundException exception){
       String status = "Status: " + HttpStatus.NOT_FOUND.value();

       return new ErroDTO(exception.getMessage(), status);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(CategoriaIdNotFoundException.class)
    private ErroDTO categoriaIdNotFound(CategoriaIdNotFoundException exception){
       String status = "Status: " + HttpStatus.NOT_FOUND.value();
       return new ErroDTO(exception.getMessage(), status);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(FaixaPrecoNotFoundException.class)
    private ErroDTO faixaPrecoNotFound(FaixaPrecoNotFoundException exception){
        String status = "Status: " + HttpStatus.NOT_FOUND.value();
        return new ErroDTO(exception.getMessage(), status);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(EventoNotFoundException.class)
    private ErroDTO eventoNotFound(EventoNotFoundException exception){
        String status = "Status: " + HttpStatus.NOT_FOUND.value();
        return new ErroDTO(exception.getMessage(), status);
    }







}
