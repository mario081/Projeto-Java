package com.biblioteca.sistema_biblioteca.confg;

import com.biblioteca.sistema_biblioteca.exceptions.ResourceNotFoundException;
import com.biblioteca.sistema_biblioteca.utils.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonResponse<?>> handleResourceNotFoundException(ResourceNotFoundException e) {

        CommonResponse<?> errorResponse = new CommonResponse<>(
                HttpStatus.NOT_FOUND,
                e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<?>> handleGeneralException(Exception e) {

        String message = "Ocorreu um erro interno no servidor.";

        CommonResponse<?> errorResponse = new CommonResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                message
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
