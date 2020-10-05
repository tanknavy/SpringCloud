import com.tanknavy.springcloud.PaymentApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Alex Cheng 9/30/2020 12:58 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PaymentApp.class}) //新版本要求传入
public class PaymentAppTests {

    @Autowired
    DataSource dataSource;

    @Test
    //public void contextLoads() throws SQLException {
    public void test01() throws SQLException {
        //spring.datasource.type从默认数据源切换成 com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass()); //数据源类型org.apache.tomcat.jdbc.pool.DataSource

        Connection connection = dataSource.getConnection();
        System.out.println(connection); //PooledConnection[com.mysql.jdbc.JDBC4Connection
        connection.close();

    }
}
