//package here

public class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message); //inheriting message from exception
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);

    }
}










