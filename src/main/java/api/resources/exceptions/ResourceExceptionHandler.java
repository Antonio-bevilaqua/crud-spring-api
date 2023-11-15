package api.resources.exceptions;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            ResourceNotFoundException resourceNotFoundException, 
            HttpServletRequest request
        ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return new ResponseEntity<StandardError>(new StandardError(
                timestamp.toString(),
                status.toString(),
                resourceNotFoundException.getMessage(),
                "Usuário não encontrado",
                request.getRequestURL().toString()
            ), status);
    }
}