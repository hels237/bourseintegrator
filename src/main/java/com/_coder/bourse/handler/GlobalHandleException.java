package com._coder.bourse.handler;

import com._coder.bourse.exception.CommuneNotFoundException;
import com._coder.bourse.exception.ObjectValidationException;
import com._coder.bourse.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(CommuneNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerException(CommuneNotFoundException exception) {

        final HttpStatus status = HttpStatus.NOT_FOUND;
       ErrorResponse error= ErrorResponse.builder()
                                .messageError(exception.getMessage())
                                .httpErrorStatus(status.value())
                                .build();
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerException(UserNotFoundException exception) {

        final HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error= ErrorResponse.builder()
                .messageError(exception.getMessage())
                .httpErrorStatus(status.value())
                .build();
        return ResponseEntity.ok(error);
    }

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ErrorResponse> handlerException(ObjectValidationException exception) {

        final HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ErrorResponse error= ErrorResponse.builder()
                .msgViolations(exception.getViolations())
                .httpErrorStatus(status.value())
                .build();
        return ResponseEntity.ok(error);
    }

}
