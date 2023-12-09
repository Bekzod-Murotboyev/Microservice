package dev.bekzod.courierservice.exceptions;

import dev.bekzod.courierservice.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TargetNotFoundException.class)
    public ResponseEntity<Response<String>> targetNotFoundExceptionHandler(TargetNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Response<String>(ex.getMessage()));
    }
}
