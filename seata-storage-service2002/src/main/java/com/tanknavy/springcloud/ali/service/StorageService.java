package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.domain.Storage;

public interface StorageService {

    CommonResult decrease(Storage storage);
}
