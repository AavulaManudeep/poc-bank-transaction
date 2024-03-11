package com.bank.poc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    //public static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Before("bankSensitiveData()")
    public void logBefore(){
        //logger.info("Before every method in the Controller");
        System.out.println("Before every method in the Controller");
    }

    @Pointcut("@annotation(com.bank.poc.customannotation.BankSensitiveData)")
    public void bankSensitiveData(){
        //logger.info("Before every method in the Controller");
        //System.out.println("Annotation");
    }
//    @Before("execution(* com.bank.poc.controller.*.*(..))")
//    public void logBefore(){
//        //logger.info("Before every method in the Controller");
//        System.out.println("Before every method in the Controller");
//    }


}
