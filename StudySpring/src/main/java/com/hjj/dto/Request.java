package com.hjj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangjj24
 * @date 2021-8-12 11:00
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request<T> implements BaseRequest {

    private T request;

}
