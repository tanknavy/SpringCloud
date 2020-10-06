package com.tanknavy.springcloud.ali.controller;

import com.tanknavy.springcloud.ali.domain.Account;
import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alex Cheng 10/6/2020 10:22 AM
 */

@RestController
public class ServiceAccount {

    @Autowired
    AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(Account account){
        accountService.decrease(account);
        return new CommonResult(200, "account deduct ok...");
    }
}
