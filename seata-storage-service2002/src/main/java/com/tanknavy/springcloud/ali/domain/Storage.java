package com.tanknavy.springcloud.ali.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Alex Cheng 10/6/2020 9:16 AM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;//总库存
    private Integer used; //已用库存
    private Integer residue;//剩余库存

}
