package com.tanknavy.springcloud.ali.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Alex Cheng 10/5/2020 8:01 PM
 */

@Data //lombok产生setter/getter/constructor/tostring/hashCode, 相当于@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@AllArgsConstructor //全部参数
@NoArgsConstructor //空参
public class CommonResult<T> { //泛型返回
    private Integer code;
    private String message;
    private T data;

    //前两个参数code和message的构造器
    public CommonResult(Integer code, String message) {
        this(code, message,null); //this调用其它构造器
    }

}
