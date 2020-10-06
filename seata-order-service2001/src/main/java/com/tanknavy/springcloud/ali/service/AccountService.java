package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

//账户微服务,dubbo是RPC, Feign是http
@FeignClient(value = "seata-account-service")
public interface AccountService {

    //写操作，发的post
    @PostMapping("/account/decrease") //调用微服务下面url，对userId做money扣减
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money); //不写RequestParam默认按名称对应
}
