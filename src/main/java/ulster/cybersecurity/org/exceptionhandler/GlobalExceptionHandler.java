package ulster.cybersecurity.org.exceptionhandler;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDuplicateKeyException(DuplicateKeyException e) {
        return "A role with the same name already exists.";
    }

    @ExceptionHandler({DefaultRoleNotFoundException.class, RoleNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRoleRelatedExceptions(RuntimeException e) {
        return e.getMessage();
    }
}
