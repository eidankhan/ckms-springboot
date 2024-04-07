package ulster.cybersecurity.org.exceptionhandler;

public class DefaultRoleNotFoundException extends RuntimeException {
    public DefaultRoleNotFoundException(String message) {
        super(message);
    }
}
