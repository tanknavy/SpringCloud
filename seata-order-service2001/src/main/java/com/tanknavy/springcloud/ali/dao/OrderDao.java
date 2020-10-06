package com.tanknavy.springcloud.ali.dao;

import com.tanknavy.springcloud.ali.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //mybatis，可以注解写sql，也可以mapper.xml文件
public interface OrderDao { //dao接口由mybatis实现

    //1.新建订单
    void create(Order order);

    //2.修改订单转态,从0到1(创建中->已完结)
    void update(@Param("userId") Long userId, @Param("status") Integer status); //sql栏位和形参映射
}
