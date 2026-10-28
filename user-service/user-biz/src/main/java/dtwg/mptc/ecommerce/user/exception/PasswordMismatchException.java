package dtwg.mptc.ecommerce.user.exception;

import dtwg.mptc.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends GlobalException {
    public PasswordMismatchException(HttpStatus status, String message) {
        super(status, message);
    }
}
