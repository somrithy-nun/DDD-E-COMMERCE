package dtwg.mptc.ecommerce.user.exception;

import dtwg.mptc.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GlobalException  {
    public UserNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
