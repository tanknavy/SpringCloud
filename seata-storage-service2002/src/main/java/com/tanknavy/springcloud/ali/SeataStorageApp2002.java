package com.tanknavy.springcloud.ali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author: Alex Cheng 10/6/2020 9:12 AM
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //使用定制的seata DataSourceProxy
public class SeataStorageApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApp2002.class, args);
    }
}
