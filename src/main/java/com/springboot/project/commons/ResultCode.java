package com.springboot.project.commons;

import lombok.Data;

/**
 * 返回状态码枚举
 * @Author:zzh
 * @CreateDate:2020/11/4 10:51
 * @Description:
 */

public enum ResultCode {

    PARAM_NULL(701,"传入的参数为null"),
    ARITHMETIC_EXC(702,"算数异常"),
    DIVIDER_EXC(703,"除数为0"),
    OK(200,"返回正确"),
    ERROR(500,"服务器发生错误");

    private Integer code;

    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
