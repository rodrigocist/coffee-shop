package com.coffee.shop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class ApiLogs {


    @Pointcut("execution(* com.coffee.shop.controllers.*.* (..))")
    public void allResource(){

    }

    @Before("allResource()")
    public void requestLog(JoinPoint joinPoint){
        log.info("===== requestLog logging request=====");
        String logger = joinPoint.getSignature().getDeclaringTypeName() +" " + joinPoint.getSignature().getName() +" > ";
        for(Object arg : joinPoint.getArgs()){
            logger += "\n arg: " + arg;
        }
        log.info(logger);




        String SQL_LISTAR = "select * from TABLA inner join TABLA_extended where 1 = 1";

        String sql = SQL_LISTAR.replaceAll("TABLA", "agente");

        log.info("SQL_LISTAR: " + sql);

    }

    @AfterReturning(pointcut = "allResource()", returning = "result")
    public void responseLog(JoinPoint joinPoint, Object result){
        log.info("===== responseLog logging request=====");
        String logger = joinPoint.getSignature().getDeclaringTypeName() + " < Return < " + joinPoint.getSignature().getName() + " : " + result;
        log.info(logger);
    }

    @AfterThrowing(pointcut = "allResource()", throwing = "exception")
    public void exceptionLog(JoinPoint joinPoint, Exception exception){
        log.info("===== exceptionLog logging request=====");
        String logger = joinPoint.getSignature().getDeclaringTypeName() +" < Return Exception < " + joinPoint.getSignature().getName() + " : " + exception.getClass().getSimpleName();
        log.info(logger);
    }


    @Before("execution(* com.coffee.shop.controllers.*.get*())")
    public void getAllAdvice(){
        log.info("=== SOLO METODOS CON nombre GET");
    }


    @Before("execution(* com.coffee.shop.controllers.*.post*())")
    public void postMethod(){
        log.info("=== SOLO METODOS CON POST");
    }



}
