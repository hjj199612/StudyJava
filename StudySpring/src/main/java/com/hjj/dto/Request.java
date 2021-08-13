package com.hjj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

/**
 * @author huangjj24
 * @date 2021-8-12 11:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Request", description = "统用请求")
public class Request<T> implements BaseRequest {

    @Valid
    @ApiModelProperty(value = "接口参数")
    private T request;

    public static <T> Request<T> build(T request) {
        return new Request<>(request);
    }
}
