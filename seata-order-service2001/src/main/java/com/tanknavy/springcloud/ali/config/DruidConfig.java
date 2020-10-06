package com.tanknavy.springcloud.ali.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Alex Cheng 9/30/2020 2:16 PM
 */

//@Configuration //使用新的DataSourceProxyConfig, 有DruidDataSource<--Seata DataSourceProxy <-- SqlSessionFactory
public class DruidConfig {
    //自定义数据源,并且读入配置信息

    @ConfigurationProperties(prefix = "spring.datasource")//从全局配置文件中拿到属性字段/值和DruidDataSource对象属性绑定
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控,
    //1.配置进入管理后台请求的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");//对/druid资源下面访问

        Map<String,String> initParams = new HashMap<>();//参数
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123");
        initParams.put("allow", ""); //默认容许所有访问，可写localhost
        initParams.put("deny", "192.168.1.187");//拒绝，测试用

        bean.setInitParameters(initParams);
        return bean;
    }

    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();//bean
        bean.setFilter(new WebStatFilter()); //bean中的web过滤

        Map<String,String> initParams = new HashMap<>();//参数
        initParams.put("exclusions", "*.js, *.css, /druid/*");//不拦截静态请求，druid请求
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/**"));//拦截所有请求

        return bean;
    }

}
