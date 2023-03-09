package com.zhaowei.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhaowei.springcloud.utils.ResponseInfo;

public class CustomerBlockHandler {
    public static ResponseInfo handlerException(BlockException exception) {
        return new ResponseInfo(4444, "按客戶自定义,global handlerException----1");
    }

    public static ResponseInfo handlerException2(BlockException exception) {
        return new ResponseInfo(4444, "按客戶自定义,global handlerException----2");
    }
}
