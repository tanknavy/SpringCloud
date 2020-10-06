import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.tanknavy.springcloud.PaymentApp;
import com.tanknavy.springcloud.utils.SnowFlakeIDGen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: Alex Cheng 9/30/2020 12:58 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PaymentApp.class}) //新版本要求传入
public class PaymentAppTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    SnowFlakeIDGen snowFlakeIDGen;

    @Test
    public void contextLoads() throws SQLException {
    //public void test01() throws SQLException {
        //spring.datasource.type从默认数据源切换成 com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass()); //数据源类型org.apache.tomcat.jdbc.pool.DataSource

        Connection connection = dataSource.getConnection();
        System.out.println(connection); //PooledConnection[com.mysql.jdbc.JDBC4Connection
        connection.close();
    }

    //uniqueID: uuid(32个16进制数据，连号分5段), DB automatic increment,
    //snowflake雪花算法
    @Test
    public void uuidTest(){
        System.out.println(UUID.randomUUID().toString());//53fd372f-ac73-4468-8b2f-64fa9a75bdc0
    }

    @Test
    public void pos2negTest(){
        int n = 1;
        int m = 0;
        while(n>0){
            n = n << 1;
            m+=1;
        }
        System.out.println(n + "--" + m);
    }

    @Test
    public void timeTest(){
        Long n = 1L;
        for (int i=0;i<41;i++){
            n = n << 1;
        }
        System.out.println(n);
        Date date = new Date();
        date.setTime(n);
        System.out.println(new SimpleDateFormat("yyyy-MM--dd").format(date));//2039-09--07
    }

    @Test
    public void sfTest(){
        long workerIdBits = 5L;
        //计算机中负数使用补码表示(1.二进制正数先取反，2.再+1，比如-4电路中就是111...100, -1是111...111)
        final long maxWorkerId = -1L ^ (-1L << workerIdBits); //位运算， &，|，~, ^,与，或，非，异或
        System.out.println(maxWorkerId);
    }

    @Test
    public void huTool(){
        long workerId = 1;//(0~31)
        long datacenterId = 1;//(0~31)
        Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
        System.out.println(snowflake.nextId());

        long id = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());//当前ip
        System.out.println(NetUtil.getLocalhostStr().hashCode());//1562697145

    }

    @Test
    public void myId(){
        //线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for(int i=0;i<20;i++){
            threadPool.submit(() ->{ //匿名内部类，接口只有一个方法需要实现时，直接写方法
                System.out.println(snowFlakeIDGen.snowflakeId());
            });
        }

    }




}
