package ru.task.socks.exception;


import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(PSQLException.class)
    public ResponseEntity<HttpStatus> badRequestHandler(PSQLException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SocksCustomException.class)
    public ResponseEntity<?> socksCustomExceptionHandler(SocksCustomException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
