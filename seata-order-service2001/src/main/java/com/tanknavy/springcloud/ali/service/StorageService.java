package com.tanknavy.springcloud.ali.service;


import com.tanknavy.springcloud.ali.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//远程服务调用(微服务名称)
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    //写操作，发的post
    @PostMapping(value = "/storage/decrease") //调用微服务的这个url，对productId做count库存减少
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);//商品id减库存count
}
