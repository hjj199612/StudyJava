package com.hjj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

/**
 * @author huangjj24
 * @date 2021-8-12 11:38
 **/
@Component
@Slf4j
@Aspect
public class LogAspect {


    static {
        log.info("LogAspect初始化执行静态代码块");
    }

    @Value("${param.param1}")
    String param1;
    @Value("${param.param2}")
    String param2;
    @Value("${param.param3}")
    String param3;

    @Pointcut("@annotation(com.hjj.aop.Log)")
    public void logAspect() {
    }

    @Around("logAspect()")
    public void doAround(ProceedingJoinPoint pjp) throws Throwable {
        //切点所在的类
        Class<?> targetClass = pjp.getTarget().getClass();
        //使用了注解的方法
        String methodName = pjp.getSignature().getName();
        Parameter[] parameters = ((MethodSignature) pjp.getSignature()).getMethod().getParameters();
        Parameter parameter = parameters[0];
        parameter.getParameterizedType();
        log.info(param1, param2, param3);
        log.info("环绕增强前面");
        pjp.proceed();//切点
        log.info("环绕增强后面");
    }
}
