package com.tanknavy.springcloud.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Author: Alex Cheng 9/30/2020 10:47 PM
 */

//自定义myBatis的配置规则，比如bean属性和table栏位的映射lastName->last_name
//如果使用myBatis注解方式，也可以在mybatis配置文件中配置
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);//开启驼峰命名映射
            }
        };
    }
}
