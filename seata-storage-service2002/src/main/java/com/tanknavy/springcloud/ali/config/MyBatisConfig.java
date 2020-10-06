package com.tanknavy.springcloud.ali.config;

import org.mybatis.spring.annotation.MapperScan;

/**
 * Author: Alex Cheng 9/30/2020 10:47 PM
 */

//自定义myBatis的配置规则，比如bean属性和table栏位的映射lastName->last_name
//如果使用myBatis注解方式，也可以在mybatis配置文件中配置
@org.springframework.context.annotation.Configuration //配置类
@MapperScan("com.tanknavy.springcloud.ali.dao") //mybatis对应的dao包
public class MyBatisConfig {

    //可以在这里写驼峰命名规则，也可以mybatis-config.xml文件指定,全部配置文件中指定这个文件
//    @Bean
//    public ConfigurationCustomizer configurationCustomizer(){
//        return new ConfigurationCustomizer() {
//            @Override
//            public void customize(Configuration configuration) {
//                configuration.setMapUnderscoreToCamelCase(true);//开启驼峰命名映射
//            }
//        };
//    }
}
