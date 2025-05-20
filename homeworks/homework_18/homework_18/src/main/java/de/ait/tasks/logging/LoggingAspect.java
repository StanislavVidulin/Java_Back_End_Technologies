package de.ait.tasks.logging;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Aspect
public class LoggingAspect {
    private final Logger logger;

    //    @Before("execution(* de.ait.tasks.service.TaskServiceImpl.*(..))")
//    public void helloAOP(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        logger.info(methodName + ": start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//    }
    @Before("execution(* de.ait.tasks.service.TaskServiceImpl.*(..))")
    public void helloAOP(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(methodName + ": start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}