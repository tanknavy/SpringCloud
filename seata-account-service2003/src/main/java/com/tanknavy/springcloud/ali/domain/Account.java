package com.tanknavy.springcloud.ali.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Author: Alex Cheng 10/6/2020 10:09 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;//总额度
    private BigDecimal used;//使用多了
    private BigDecimal residue;//剩余多少

}
