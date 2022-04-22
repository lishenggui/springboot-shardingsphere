package com.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@TableName("t_order")
public class Order extends Model<Order> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Long orderId;
    private Long userId;
    private BigDecimal amount;
    private BigDecimal discount;
    private Date createTime;
}
