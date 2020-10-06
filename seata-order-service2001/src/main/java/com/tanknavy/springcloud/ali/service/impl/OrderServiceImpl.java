package com.tanknavy.springcloud.ali.service.impl;

import com.tanknavy.springcloud.ali.dao.OrderDao;
import com.tanknavy.springcloud.ali.domain.Order;
import com.tanknavy.springcloud.ali.service.AccountService;
import com.tanknavy.springcloud.ali.service.OrderService;
import com.tanknavy.springcloud.ali.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: Alex Cheng 10/5/2020 9:09 PM
 */
@Service
@Slf4j //lombok下Slf4j
public class OrderServiceImpl implements OrderService {

    //@Autowired wires per type and @Resource wires per bean name. But @Autowired in combination with @Qualifier also autowires by name.
    //@Autowired is a spring annotation whereas @Resource is specified by the JSR-250
    //@Autowired  //Autowired是Spring，@Resource是javax的
    @Resource//javax注释在class,field,method上按照bean名称, Autowired是spring注释，默认按照type类型， @Qualifier也可以通过名称
    private OrderDao orderDao;
    @Resource
    private StorageService storageService; //微服务
    @Resource
    private AccountService accountService; //微服务

    @Override
    public void create(Order order) {
        //1.创新订单，驱动一个distributed transaction
        log.info("------>开始创建订单");
        orderDao.create(order);

        //2.微服务-库存扣减
        log.info("------>订单微服务开始调用库存，做扣减count"); //post
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务开始调用库存，做扣减end");

        //3.微服务-账户扣减
        log.info("------>账户维服务开始调用账户，做money扣款");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>账户维服务开始调用账户，做money扣款end");


        //4.修改订单状态(假如上述order->storage->account三个事物都ok)，从0到1(1表示完成)
        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");

        log.info("------>下订单结束了~~~~");

    }
}
