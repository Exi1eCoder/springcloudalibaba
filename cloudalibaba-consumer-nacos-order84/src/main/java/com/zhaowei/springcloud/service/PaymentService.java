package com.zhaowei.springcloud.service;

import com.zhaowei.springcloud.entities.Payment;
import com.zhaowei.springcloud.utils.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/paymentSQL/{id}")
    public ResponseInfo<Payment> paymentSQL(@PathVariable("id") Long id);
}
