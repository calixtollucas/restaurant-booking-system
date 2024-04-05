package dev.ruka.restaurantbookingsystem.exceptions;

public class ServerSideException extends RuntimeException{
    public ServerSideException(String message) {
        super(message);
    }

    public ServerSideException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerSideException(Throwable cause) {
        super(cause);
    }
}
