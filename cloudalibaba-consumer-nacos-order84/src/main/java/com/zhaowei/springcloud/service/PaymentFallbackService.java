package com.zhaowei.springcloud.service;

import com.zhaowei.springcloud.entities.Payment;
import com.zhaowei.springcloud.utils.ResponseInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public ResponseInfo<Payment> paymentSQL(Long id) {
        return new ResponseInfo<>(44444, "服务降级返回,-----------PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
