package dtwg.mptc.ecommerce.user.controller.exception.handler;

import dtwg.mptc.ecommerce.restapi.dto.RestApiErrorResponse;
import dtwg.mptc.ecommerce.restapi.exception.GlobalException;
import dtwg.mptc.ecommerce.restapi.exception.GlobalExceptionHandler;
import dtwg.mptc.ecommerce.user.config.KeycloakException;
import dtwg.mptc.ecommerce.user.exception.PasswordMismatchException;
import dtwg.mptc.ecommerce.user.exception.UserHybridDataInconsistencyException;
import dtwg.mptc.ecommerce.user.exception.UserNotFoundException;
import dtwg.mptc.ecommerce.user.exception.UsernameConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserGlobalExceptionHandler  extends GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(KeycloakException.class)
    public RestApiErrorResponse<?> handle(
            KeycloakException e
    ) {
        return build(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PasswordMismatchException.class)
    public RestApiErrorResponse<?> handle(
            PasswordMismatchException e
    ) {
        return build(e);
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UsernameConflictException.class)
    public RestApiErrorResponse<?> handle(
            UsernameConflictException e
    ) {
        return build(e);
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public RestApiErrorResponse<?> handle(
            UserNotFoundException e
    ) {
        return build(e);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserHybridDataInconsistencyException.class)
    public RestApiErrorResponse<?> handle(
            UserHybridDataInconsistencyException e
    ) {
        return build(e);
    }


    private RestApiErrorResponse<?> build(GlobalException e) {
        return RestApiErrorResponse.builder()
                .code(e.getStatus().getReasonPhrase())
                .message(e.getMessage())
                .build();
    }
}
