package ru.task.socks.exceptionHandler;


import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PSQLExceptionHandler {

    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<HttpStatus> badRequestHandler(PSQLException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
