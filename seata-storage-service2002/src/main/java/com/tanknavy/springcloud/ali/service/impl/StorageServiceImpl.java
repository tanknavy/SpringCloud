package com.tanknavy.springcloud.ali.service.impl;

import com.tanknavy.springcloud.ali.dao.StorageDao;
import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.domain.Storage;
import com.tanknavy.springcloud.ali.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: Alex Cheng 10/6/2020 9:26 AM
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageDao storageDao;

    @Override
    public CommonResult decrease(Storage storage) {
        storageDao.decrease(storage);
        return new CommonResult(200, "storage deduct ok...");
    }
}
