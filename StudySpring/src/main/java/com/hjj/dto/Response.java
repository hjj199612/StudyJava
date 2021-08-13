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
public class Response<T> {

    private T data;

    private String code;

    private String msg;

    public static <T> Response<T> getSuccessResp(T data) {
        Response<T> build = new Response<>();
        build.setData(data);
        build.setCode("0000");
        build.setMsg("successful");
        return build;
    }

    public static <T> Response<T> getFailsResp(String code, Throwable throwable) {
        Response<T> build = new Response<>();
        build.setCode(code);
        build.setMsg(throwable.getMessage());
        return build;
    }

    public static <T> Response<T> getFailsResp(String code, String msg) {
        Response<T> build = new Response<>();
        build.setCode(code);
        build.setMsg(msg);
        return build;
    }
}
