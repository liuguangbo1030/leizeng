package com.udp.nb.util;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author cloudy
 * @version 1.0
 * @date 2016/9/1
 */
public class HttpResult<T> {
    @Value("0")
    private Integer code;

    @Value("success")
    private String message;

    private T data;

    public HttpResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
