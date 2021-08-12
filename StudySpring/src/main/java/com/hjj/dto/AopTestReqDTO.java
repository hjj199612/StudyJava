package com.hjj.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author huangjj24
 * @date 2021-8-12 11:06
 **/
@Data
@ApiModel("消息")
public class AopTestReqDTO {

    @ApiModelProperty(value = "消息内容", required = true)
    @NotBlank(message = "消息内容不能为孔")
    private String msg;
}
