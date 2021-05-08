package com.definesys.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/07 16:31
 * @history: 1.2021/05/07 created by shuaishuai.li
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduException extends RuntimeException {
    @ApiModelProperty(value = "错误状态码")
    private Integer code;

    private String msg;

}