package com.hjj.dto;

import lombok.Data;

import javax.validation.Valid;

/**
 * @author huangjj24
 * @date 2021-8-12 11:00
 **/
@Data
public class Request<T> implements BaseRequest {

    @Valid
    private T request;

}
