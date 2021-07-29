package com.example.ui2_demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAop {
    Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Around("execution(* com.example.ui2_demo.controller.MainController.*(..))")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("start - "+pjp.getSignature().getDeclaringTypeName()+" / "+pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;

    }
}
