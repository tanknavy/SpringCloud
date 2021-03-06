package com.tanknavy.springcloud.ali.dao;

import com.tanknavy.springcloud.ali.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * Author: Alex Cheng 10/6/2020 10:11 AM
 */

@Mapper
public interface AccountDao { //mybatis实现接口
    //void decrease(Account account);
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
