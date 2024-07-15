package learn.data;

public class DataAccessException extends Throwable {
    public DataAccessException(String message, Throwable rootCause){
        super(message, rootCause);
    }
}
