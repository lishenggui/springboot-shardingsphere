package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.model.Order;
import com.demo.model.OrderDto;
import com.demo.model.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService extends IService<Order> {
    boolean save(Order order, List<OrderItem> items);
    List<OrderDto> getOrderDetails(@Param("orderId") Integer orderId);
}