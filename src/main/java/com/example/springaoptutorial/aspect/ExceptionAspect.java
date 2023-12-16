package com.example.springaoptutorial.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.example.springaoptutorial.annotation.Logging)")
    void callAtBookService() {}

    @Before("callAtBookService()")
    void beforeCallAtBookService(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        log.info("Before method {}, args=[{}]", joinPoint, args);
    }

    @AfterReturning(value = "callAtBookService()", returning = "returnValue")
    void afterCallAtBookService(JoinPoint joinPoint, Object returnValue) {
        log.info("After method {}, return={}", joinPoint, returnValue);
    }
}
