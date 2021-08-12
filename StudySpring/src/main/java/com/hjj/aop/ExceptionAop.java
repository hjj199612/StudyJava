package com.hjj.aop;

import java.lang.annotation.*;

/**
 * @author huangjj24
 * @date 2021-8-12 11:27
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionAop {
}
