package com.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("t_order_item")
public class OrderItem extends Model<OrderItem> {
    private Long orderId;
    private Long productId;
    private String productName;
    private BigDecimal price;
    private BigDecimal discount;
    @TableField("`count`")
    private int count;

    public OrderItem(){}

    public OrderItem(Long orderId,Long productId,String productName,BigDecimal price,BigDecimal discount,int count){
        this.orderId=orderId;
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.discount=discount;
        this.count=count;
    }
}