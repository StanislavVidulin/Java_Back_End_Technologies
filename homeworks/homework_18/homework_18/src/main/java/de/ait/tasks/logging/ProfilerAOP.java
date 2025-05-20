package de.ait.tasks.logging;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ProfilerAOP {
    private final Logger logger;

    @Around("@annotation(de.ait.tasks.logging.Profiler)")
    public Object setProfiler(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.toShortString();

        logger.info("PROFILER: " + name + " start");
        long start = System.currentTimeMillis();

        Object result;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long time = System.currentTimeMillis() - start;
        logger.info("PROFILER: " + name + " finish " + time + " msec Result " + result);
        return result;
    }
}
