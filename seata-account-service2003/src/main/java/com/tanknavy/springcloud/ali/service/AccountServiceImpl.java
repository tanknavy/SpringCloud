package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.dao.AccountDao;
import com.tanknavy.springcloud.ali.domain.Account;
import com.tanknavy.springcloud.ali.domain.CommonResult;

import javax.annotation.Resource;

/**
 * Author: Alex Cheng 10/6/2020 10:21 AM
 */
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public CommonResult decrease(Account account) {
        accountDao.decrease(account);
        return null;
    }
}
