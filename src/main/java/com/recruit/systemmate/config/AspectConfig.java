package com.recruit.systemmate.config;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Around("execution(* com.recruit.*mate..controller.*.*(..)) && @within(org.springframework.web.bind.annotation.RestController)")
    public Object aroundRecruitmateController(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        HttpServletResponse response = null;

        for(Object obj : args){
            if(obj instanceof HttpServletRequest){
                request = (HttpServletRequest) obj;
            }else if(obj instanceof HttpServletRequest){
                response = (HttpServletResponse) obj;
            }
        }

        return null;
    }
}
