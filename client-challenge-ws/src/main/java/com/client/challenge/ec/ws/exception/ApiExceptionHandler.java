package com.client.challenge.ec.ws.exception;

import com.client.challenge.ec.bs.exception.ModelNotFoundException;
import com.client.challenge.ec.ws.common.StandardApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardApiExceptionResponse> handleException(Exception e) {
        StandardApiExceptionResponse response = new StandardApiExceptionResponse("Internal Server Error", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<StandardApiExceptionResponse> handleModelNotFoundException(ModelNotFoundException e) {
        StandardApiExceptionResponse response = new StandardApiExceptionResponse("Model Not Found", String.valueOf(HttpStatus.NOT_FOUND.value()), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardApiExceptionResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        StandardApiExceptionResponse response = new StandardApiExceptionResponse("Illegal Argument", String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<StandardApiExceptionResponse> handleIllegalStateException(IllegalStateException e) {
        StandardApiExceptionResponse response = new StandardApiExceptionResponse("Illegal State", String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardApiExceptionResponse> handleNullPointerException(NullPointerException e) {
        StandardApiExceptionResponse response = new StandardApiExceptionResponse("Null Pointer", String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
