package com.zhaowei.springcloud.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseInfo(Integer code, String message){
        this(code, message, null);
    }
}
