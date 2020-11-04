package com.springboot.project.commons;

import lombok.Data;

/**
 * 控制层统一的返回对象
 * @Author:zzh
 * @CreateDate:2020/11/4 10:57
 * @Description:
 */
@Data
public class ResultObj<T> {
    /** 返回的状态码 */
    private Integer code;
    /** 返回的消息 */
    private String message;
    /** 返回的数据 */
    private T data;

    public ResultObj(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ResultObj(ResultCode resultCode,T t){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = t;
    }


    public ResultObj(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultObj(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public static <T> ResultObj<T> ok(){
        return new ResultObj<T>(ResultCode.ERROR);
    }

    public static <T> ResultObj<T> ok(String message){
        return new ResultObj<T>(ResultCode.OK.getCode(),message);
    }

    public static <T> ResultObj<T> error(ResultCode resultCode){
        return new ResultObj<T>(resultCode);
    }

    public static <T> ResultObj<T> error(){
        return error(ResultCode.ERROR);
    }

    public static <T> ResultObj<T> error(Integer code,String message){
        return new ResultObj<T>(code,message);
    }
}
