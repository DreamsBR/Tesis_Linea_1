package com.lineauno.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lineauno.utils.GenericResponse;
import com.lineauno.utils.Globals;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(Exception.class)
    public GenericResponse genericException(Exception ex) {
        return new GenericResponse("exception", -1, Globals.OPERACION_ERRONEA, ex.getMessage());
    }
	
}
