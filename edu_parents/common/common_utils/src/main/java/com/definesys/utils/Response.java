package com.definesys.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/03 12:02
 * @history: 1.2021/05/03 created by shuaishuai.li
 */
@Data
public class Response {
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("返回数据")
    private HashMap<String,Object> data = new HashMap<>();

    private Response(){}

    public static Response ok(){
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS);
        response.setMessage("成功");
        return response;
    }

    public static Response error(){
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(ResponseCode.ERROR);
        response.setMessage("失败");
        return response;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }

    public Response success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response data(HashMap<String,Object> data){
        this.setData(data);
        return this;
    }

    public Response data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

}