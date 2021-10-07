package ru.task.socks.exceptionHandler;

public class SocksCustomException extends Exception {

    private String message;

    public SocksCustomException() {
    }

    public SocksCustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
