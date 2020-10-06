package com.tanknavy.springcloud.ali.controller;

import com.tanknavy.springcloud.ali.domain.Account;
import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Author: Alex Cheng 10/6/2020 10:22 AM
 */

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    //扣减账户余额
    @PostMapping("/account/decrease") //其它微服务使用Feign调用
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "account deduct ok...");
    }
}
