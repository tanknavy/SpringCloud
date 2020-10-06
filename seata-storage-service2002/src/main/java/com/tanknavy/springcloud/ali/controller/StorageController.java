package com.tanknavy.springcloud.ali.controller;

import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Alex Cheng 10/6/2020 9:36 AM
 */

@RestController
public class StorageController {
    @Autowired
    StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功");
    }

}
