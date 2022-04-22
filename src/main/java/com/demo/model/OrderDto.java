package com.demo.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto  {
    private  String productName;

    private Long orderId;
    private Long userId;
    private BigDecimal amount;
    private BigDecimal discount;
    private Date createTime;
}
