package com.tanknavy.springcloud.ali.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Author: Alex Cheng 10/5/2020 10:13 PM
 * 使用Seata对数据源进行代理
 */
@Configuration
public class DataSourceProxyConfig { //Seata代替Druid做DataSourceProxy

    //流程 DB<--DruidDataSource<--DataSourceProxy<--SqlSessionFactory
    //mybatis mapper文件位置
    @Value("${mybatis.mapper-locations}") //从默认的全局配置文件中读取属性
    //@Value("${mybatis.mapperLocations}") //从默认的全局配置文件中自定义属性名称读取属性
    private String mapperLocations;//获得mybatis的mapper位置

    @Bean //DruidDataSource的配置,bean属性和属性文件中按名称match
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){ //javax.sql.DataSource
        return new DruidDataSource();
    }

    @Bean //使用Seata的DataSourceProxy对DruidDataSource的配置数据源进行代理
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    @Bean //mybatis的SqlSessionFactory对Seata的DataSourceProxy
    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory()); //
        return sqlSessionFactoryBean.getObject();
    }
}
