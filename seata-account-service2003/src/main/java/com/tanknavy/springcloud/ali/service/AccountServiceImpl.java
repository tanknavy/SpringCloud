package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.dao.AccountDao;
import com.tanknavy.springcloud.ali.domain.Account;
import com.tanknavy.springcloud.ali.domain.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Author: Alex Cheng 10/6/2020 10:21 AM
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    //有了@Slf4j注释
    //private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource //比较Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------->AccountService账户扣减开始");
        //可以模拟异常，全局事物回滚
        accountDao.decrease(userId, money);
        log.info("------------->AccountService账户扣减结束...");
    }

}
