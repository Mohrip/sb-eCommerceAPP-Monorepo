package com.StackShop.project.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    // Define pointcut for service layer only, excluding security and filters
    @Pointcut("execution(* com.StackShop.project..*Service*.*(..)) || " +
              "execution(* com.StackShop.project..*Controller*.*(..))")
    public void applicationPointcut() {}

    // Exclude security package
    @Pointcut("!within(com.StackShop.project.security..*)")
    public void excludeSecurity() {}

    @Before("applicationPointcut() && excludeSecurity()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature());
    }
}
