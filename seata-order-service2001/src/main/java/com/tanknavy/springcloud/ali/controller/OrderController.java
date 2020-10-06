package com.tanknavy.springcloud.ali.controller;

import com.tanknavy.springcloud.ali.domain.CommonResult;
import com.tanknavy.springcloud.ali.domain.Order;
import com.tanknavy.springcloud.ali.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: Alex Cheng 10/5/2020 9:59 PM
 * 测试：get方法 http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
 */

@RestController
public class OrderController {

    //@Autowired
    @Resource
    private OrderService orderService;

    //暴露给user下订单用的，浏览器只能get,不能post，正真的写操作post用Feign调用order->storage->account
    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功...");
    }

}
