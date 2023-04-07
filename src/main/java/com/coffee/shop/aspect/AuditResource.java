package com.coffee.shop.aspect;

import com.coffee.shop.dto.CoffeeAuditDto;
import com.coffee.shop.services.CoffeeAuditService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import static com.coffee.shop.utils.Constants.METHOD_GET;

@Component
@Aspect
@Slf4j
public class AuditResource {

    @Autowired
    CoffeeAuditService coffeeAuditService;

    @Pointcut("execution(* com.coffee.shop.controllers.*.* (..))")
    public void allResource(){

    }

    @After("allResource()")
    public void aduitResource(JoinPoint joinPoint) {
        log.info("auditing api resource");
        try {
            StringBuilder params= new StringBuilder();
            for(Object arg : joinPoint.getArgs()){
                params.append(arg);
            }
            addAudit(joinPoint, params.toString());
        } catch (Throwable throwable) {
            log.error("[aduitResource] error adding audit ", throwable);
            throw throwable;
        }
    }


    private void addAudit(JoinPoint joinPoint, String params){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        String nameApi = joinPoint.getSignature().getName();

        if(!request.getMethod().equalsIgnoreCase(METHOD_GET)){
            CoffeeAuditDto coffeeAuditDto = new CoffeeAuditDto();
            coffeeAuditDto.setAction(request.getMethod());
            coffeeAuditDto.setApi(request.getRequestURI() + "/" +nameApi);
            coffeeAuditDto.setFromRequest(request.getRemoteAddr());
            coffeeAuditDto.setData(params);
            coffeeAuditDto.setUserRequest(request.getRemoteUser());
            coffeeAuditDto.setActive(true);
            coffeeAuditService.save(coffeeAuditDto);
        }

    }

            /*
    @Around("allResource()")
    public void aduitWithParam(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        Object value;

        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            log.info(
                    "{} {} from {} user id{}",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getRemoteAddr(),
                    request.getHeader("user-id"));
        }

        log.info("=== audit  : " +  value);
    }
        */

}
