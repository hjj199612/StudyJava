package com.hjj.aop;

import com.hjj.dto.AopTestReqDTO;
import com.hjj.dto.AopTestRespDTO;
import com.hjj.dto.Request;
import com.hjj.dto.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huangjj24
 * @date 2021-8-12 10:50
 **/
@RestController
@RequestMapping(value = "/aop")
@Slf4j
@Api("Aop接口")
public class AopController {


    @PostMapping(value = "/test.do")
    @ApiOperation("Aop测试接口")
    @Log
    public Response<AopTestRespDTO> aopTest(@RequestBody @Valid Request<AopTestReqDTO> request) {
        AopTestReqDTO reqDTO = request.getRequest();
        log.info("调用方法aopTest，入参：" + reqDTO.getMsg());
        return Response.getSuccessResp(new AopTestRespDTO());
    }
}
