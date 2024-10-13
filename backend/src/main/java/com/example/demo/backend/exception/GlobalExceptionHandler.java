package com.example.demo.backend.exception;

import com.example.demo.backend.bean.ErrorBean;
import com.example.demo.backend.util.GlobalResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity handleUserNotFoundExceptionException(Exception e){
        ErrorBean errorBean = new ErrorBean();
        errorBean.setErrorCode("ERR-01");
        errorBean.setErrorMessage(e.getMessage());
        return GlobalResponseHandler.createResponse(null,errorBean,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception e){
        ErrorBean errorBean = new ErrorBean();
        errorBean.setErrorCode("ERR-01");
        errorBean.setErrorMessage(e.getMessage());
        return GlobalResponseHandler.createResponse(null,errorBean,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
