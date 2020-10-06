package com.tanknavy.springcloud.ali.service.impl;

import com.tanknavy.springcloud.ali.dao.StorageDao;
import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.domain.Storage;
import com.tanknavy.springcloud.ali.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: Alex Cheng 10/6/2020 9:26 AM
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    //有了@Slf4j注释
    //private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource //对比@Autowired
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------>StorageService中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------>StorageService中扣减库存结束...");
    }
}
