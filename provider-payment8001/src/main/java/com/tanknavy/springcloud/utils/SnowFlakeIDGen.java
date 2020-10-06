package com.tanknavy.springcloud.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author: Alex Cheng 10/5/2020 9:35 AM
 */
//http://www.spring4all.com/article/17333
@Slf4j//lombok注释，相当于在本类中创建一个log实例，org.slf4j.LoggerFactory.getLogger(LogExample.class)
@Component
public class SnowFlakeIDGen { //雪花算法, 依赖机器时钟，2039年到期
    //支持最大机器id,移位算法，^异或，计算机中负数使用补码表示(1.二进制正数先取反，2.再+1，比如-4电路中就是111...100, -1是111...111)
    //private final long maxWorkerId = -1L ^ (-1L << workerIdBits); //异或，二进制最高位符号位1表示负数，0表示正数
    private long workerId = 0;
    private long datacenterId = 1;

    private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

    //dependency injection is done to perform any initialization. This method MUST be invoked before the class is put into service.
    //依赖注入后，类被使用前
    @PostConstruct //SnowFlakeIDGen     : 当前的workerId:2852041802
    public void init(){//必须无参数
        //trycf
        try { //在注入snowfalke前先检车当前机器的ip
            workerId  = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr()); //当前ip
            log.info("当前的workerId:{}", workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前的workerId获取失败", e);
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

    }

    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}
