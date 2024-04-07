package ulster.cybersecurity.org.exceptionhandler;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String message){
        super(message);
    }
}
