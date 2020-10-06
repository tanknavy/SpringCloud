package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.domain.Account;
import com.tanknavy.springcloud.ali.domain.CommonResult;

public interface AccountService {
    CommonResult decrease(Account account);
}
