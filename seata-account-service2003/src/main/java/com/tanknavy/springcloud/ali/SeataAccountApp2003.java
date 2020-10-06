package com.tanknavy.springcloud.ali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author: Alex Cheng 10/5/2020 7:59 PM
 */
@EnableDiscoveryClient //cloud远程服务发现
@EnableFeignClients //Feign客户端调用远程服务
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消DataSource自己创建，要使用自己的DruidDataSource/Seata
public class SeataAccountApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApp2003.class, args);
    }
}
