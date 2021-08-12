package com.hjj.aop;

import com.hjj.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author huangjj24
 * @date 2021-8-12 11:38
 **/
@Component
@Slf4j
@Aspect
public class ExceptionAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void exceptionAspect() {
    }

    @Around("exceptionAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            pjp.proceed();//切点
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            return Response.getFailsResp(throwable);
        }
        return null;
    }
}
