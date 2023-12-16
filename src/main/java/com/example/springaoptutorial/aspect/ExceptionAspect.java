package com.example.springaoptutorial.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    void callAtService() {}

    @Around("callAtService()")
    Object aroundCallAtService(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        }
        catch (Throwable throwable) {
            log.info("An occurred error", throwable);
            throw throwable;
        }
    }
}
