package ca.keyin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleResourceNotFound(
            ResourceNotFoundException ex) {

        Map<String, String> response = new LinkedHashMap<>();

        response.put("error", ex.getMessage());

        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleGenericException(
            Exception ex) {

        Map<String, String> response = new LinkedHashMap<>();

        response.put("error", "An unexpected error occurred.");

        return response;
    }
}
