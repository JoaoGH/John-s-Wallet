package br.com.johnswallet.api.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        DefaultApiException retorno = new DefaultApiException(e);
        log.error("erro: ", e);
        return retorno.getResponse();
    }
}
