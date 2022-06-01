package com.springboot.spring.Log;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Log {
    private final Logger log =  LoggerFactory.getLogger(this.getClass());
    
    @Before("execution(* com.springboot.spring.Controller.Student.saveStudent(..))")
    public void LogBeforeMethodCall(JoinPoint join) throws Throwable{
		
		log.info("Object is being saved " + join.getSignature().getName());
		
	}

	@After("execution(* com.springboot.spring.Controller.Student.getStudents(..))")
	public void LogAfterMethodCall(JoinPoint join) throws Throwable{
		
		log.info(join.getSignature().getName());
		
	}
}