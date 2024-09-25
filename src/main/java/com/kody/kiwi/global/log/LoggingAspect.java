package com.kody.kiwi.global.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.kody.kiwi..*(..))")
    private void publicMethod(){}

    @After("publicMethod()")
    public void log(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + "is start");
    }
}
