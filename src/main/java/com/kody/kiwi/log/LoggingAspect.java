/*
package com.kody.kiwi.log;

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
    private static final Logger LOGGING = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.kody.kiwi..*(..))")
    private void publicMethod() {}

    @After("publicMethod()")
    public void log(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGING.info(methodName + " is start"); // 공백 추가
    }
}
*/
//에러가 떠서 실패 (나중에 내가 그냥 만들려고)