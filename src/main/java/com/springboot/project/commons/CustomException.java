package com.springboot.project.commons;

import lombok.Data;

/**
 * 自定义异常
 * @Author:zzh
 * @CreateDate:2020/11/4 10:47
 * @Description:
 */
@Data
public class CustomException extends RuntimeException{
        private Integer code;

        private String message;

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, Integer code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }


    public CustomException(Throwable cause, Integer code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public CustomException(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

}
