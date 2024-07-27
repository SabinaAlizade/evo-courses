package com.example.EvoCourses.exception.handler;

import com.example.EvoCourses.exception.LessonNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import com.example.EvoCourses.exception.model.ErrorResponse;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentValidException(MethodArgumentNotValidException exception,
                                                            HttpServletRequest request){
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ErrorResponse.builder()
                .errors(errors)
                .message("Validation Failed")
                .timeStamp(LocalDateTime.now())
                .path(request.getServletPath())
                .build();

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LessonNotFoundException.class)
    public ErrorResponse handleLessonNotFoundException(LessonNotFoundException exception,
                                                       HttpServletRequest request){
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .path(request.getServletPath())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LessonNotFoundException.class)
    public ErrorResponse handleException(Exception exception,
                                         HttpServletRequest request){
        return ErrorResponse.builder()
                .message("Something went wrong")
                .timeStamp(LocalDateTime.now())
                .path(request.getServletPath())
                .build();
    }
}
