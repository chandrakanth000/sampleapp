package com.springboot.spring.Controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.spring.Model.MessageM;

@ControllerAdvice
public class ErrorHandle {
 
    Logger log =  LoggerFactory.getLogger(ErrorHandle.class);
	
	
	public ResponseEntity<MessageM> resourceNotFoundException(Throwable th){
		
		MessageM err =  new MessageM();
		err.setErrMessage(th.getMessage());
		err.setErrorDetails(th.getCause());
		err.setErrCode(th.toString());
		err.setDate(new Date());
		
		return new ResponseEntity<MessageM>(err,HttpStatus.BAD_REQUEST);
	}
	
	
}
