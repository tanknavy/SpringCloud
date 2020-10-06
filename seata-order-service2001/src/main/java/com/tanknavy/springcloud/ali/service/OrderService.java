package com.tanknavy.springcloud.ali.service;

import com.tanknavy.springcloud.ali.domain.Order;

//order驱动自己，storage, account, 分布式事务
public interface OrderService {
    void create(Order order);

}
