package com.definesys.exceptionhandler;

import com.definesys.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/07 16:16
 * @history: 1.2021/05/07 created by shuaishuai.li
 */
/*
 * 统一异常处理类
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e){
        e.printStackTrace();
        return Response.error();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Response error(ArithmeticException e){
        e.printStackTrace();
        return Response.error().message("算数异常");
    }

    @ExceptionHandler(EduException.class)
    @ResponseBody
    public Response error(EduException e){
        e.printStackTrace();
        return Response.error().code(e.getCode()).message(e.getMsg());
    }

}