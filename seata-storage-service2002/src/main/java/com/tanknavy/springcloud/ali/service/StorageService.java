package com.tanknavy.springcloud.ali.service;

//为什么要写接口，因为这个微服务要被别人调用，使用接口引用
public interface StorageService {

    //扣减库存
    //CommonResult decrease(Storage storage);
    void decrease(Long productId, Integer count);
}
