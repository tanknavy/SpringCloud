package com.tanknavy.springcloud.ali.controller;

import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.domain.Storage;
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

    @PostMapping("/storage/update")
    public CommonResult update(Storage storage){
        CommonResult result = storageService.update(storage);
        return result;
    }

}
