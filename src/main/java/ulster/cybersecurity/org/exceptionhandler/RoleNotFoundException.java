package ulster.cybersecurity.org.exceptionhandler;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}