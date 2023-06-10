package com.spring.Energy.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseStatus
public class GlobalExceptionController {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<?> exception(CustomException exception) {
        String message ="Error Code"+" "+exception.getErrCode()+"---------> Error Message: "+exception.getErrMessage();

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }




}
