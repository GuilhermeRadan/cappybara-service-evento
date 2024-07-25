package com.br.cappybaramicroserviceevento.exceptions;

public class CategoriaIdNotFoundException extends RuntimeException{

    private Long idCategoria;

    public CategoriaIdNotFoundException(String message, Long idCategoria){
        super(message);
        this.idCategoria = idCategoria;
    }

    public CategoriaIdNotFoundException(String message) {
        super(message);
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
}
