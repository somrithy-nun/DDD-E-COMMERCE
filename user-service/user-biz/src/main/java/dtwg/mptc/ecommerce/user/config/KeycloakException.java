package dtwg.mptc.ecommerce.user.config;

import dtwg.mptc.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class KeycloakException extends GlobalException {

    public KeycloakException(HttpStatus status, String message) {
        super(status, message);
    }
}
