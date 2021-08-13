package com.hjj.aop;

import com.hjj.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author huangjj24
 * @date 2021-8-12 11:38
 * @ControllerAdvice
 * 全局异常处理
 * 全局数据绑定
 * 全局数据预处理
 **/
@Slf4j
@Configuration
@ControllerAdvice
public class ControllerExceptionInterceptor {
    public ControllerExceptionInterceptor() {
    }

    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    // }

    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class, NumberFormatException.class,
            ConstraintViolationException.class})
    public Response validateHandler(Exception ex) throws Exception {
        String msg = null;
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException mex = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = mex.getBindingResult();
            msg = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(","));
        } else if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            msg = bindException.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(","));
        } else if (ex instanceof NumberFormatException) {
            msg = "参数格式错误,请输入正确的数字类型";
        } else if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationExceptio = (ConstraintViolationException) ex;
            msg = constraintViolationExceptio.getMessage();
        }
        if (StringUtils.isNoneBlank(msg)) {
            return Response.getFailsResp("9999", msg);
        } else {
            throw ex;
        }
    }
}
