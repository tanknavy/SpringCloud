package com.tanknavy.springcloud.ali.dao;

import com.tanknavy.springcloud.ali.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //mybatis注释，去找mapper.xml中sql
public interface StorageDao { //由mybatis实现

    //扣减库存used, redisue
    //void decrease(Storage storage);
    //update t_storage set used= used+5, residue=residue-5 where product_id =11;

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);//根据id修改数量
}
