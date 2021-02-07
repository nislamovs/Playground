package com.exectime.measurement.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeInterceptor {

    @Around("execution(* *.*(..)) && @annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint pjp, LogExecutionTime logExecutionTime) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        LoggerFactory.getLogger(pjp.getTarget().getClass().getSimpleName()).warn("{} {} ms",  logExecutionTime.value(), (endTime - startTime));

        return result;
    }
}
