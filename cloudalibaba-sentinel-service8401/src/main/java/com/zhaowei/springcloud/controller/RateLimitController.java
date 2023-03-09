package com.zhaowei.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhaowei.springcloud.entities.Payment;
import com.zhaowei.springcloud.myhandler.CustomerBlockHandler;
import com.zhaowei.springcloud.utils.ResponseInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public ResponseInfo byResource() {
        return new ResponseInfo(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public ResponseInfo handleException(BlockException exception) {
        return new ResponseInfo(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public ResponseInfo byUrl() {
        return new ResponseInfo(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public ResponseInfo customerBlockHandler() {
        return new ResponseInfo(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}