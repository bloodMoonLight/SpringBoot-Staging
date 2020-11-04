package com.springboot.project.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author:zzh
 * @CreateDate:2020/11/4 13:12
 * @Description:
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResultObj handlerCustomException(CustomException e){
        return new ResultObj(e.getCode(),e.getMessage());
    }
}
