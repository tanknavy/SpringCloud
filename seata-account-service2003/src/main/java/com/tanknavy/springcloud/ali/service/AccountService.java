package com.tanknavy.springcloud.ali.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService { //别人服务通过feign来post请求调用我的服务
    //构建账户余额
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
