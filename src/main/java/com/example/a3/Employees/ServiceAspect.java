package com.example.a3.Employees;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

    @Pointcut("execution(* com.example.a3.Employees.*.*(..))")
    public void serviceMethodExecution( ){

    }
    @Around(value = "serviceMethodExecution()")
    public void afterReturningAdvice(final ProceedingJoinPoint joinPoint)
    {
        System.out.println("Before return method:111111111111111"+joinPoint.getSignature());
    }


//    @Before("execution(* com.example.a3.Employees.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("Before return method:"+joinPoint.getSignature());
//
//    }
}
