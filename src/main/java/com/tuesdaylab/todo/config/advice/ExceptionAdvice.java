package com.tuesdaylab.todo.config.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Throwable.class)
    public ExceptionResponse exceptionHandle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ExceptionHandler(value = CustomException.class)
    public ExceptionResponse exceptionHandle(CustomException ex, HttpServletRequest request, HttpServletResponse response) {
        return new ExceptionResponse(ex.getMessage() + " > " +ex.getClass().getName());
    }

    @AllArgsConstructor
    @Data
    public static class ExceptionResponse {
        private String message;
    }

    public static class CustomException extends RuntimeException {
        public CustomException() {
            super();
        }

        public CustomException(String message) {
            super(message);
        }

        public CustomException(String message, Throwable cause) {
            super();
        }

        protected CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
