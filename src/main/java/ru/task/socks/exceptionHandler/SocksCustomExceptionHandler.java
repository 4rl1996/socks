package ru.task.socks.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocksCustomExceptionHandler {

    @ExceptionHandler(SocksCustomException.class)
    public ResponseEntity<?> socksCustomExceptionHandler(SocksCustomException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
