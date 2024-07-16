package com.app.exception;


import com.app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FlightControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FlightServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleFlightServiceException(FlightServiceCustomException exception) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build(),HttpStatus.NOT_FOUND);
    }

}

