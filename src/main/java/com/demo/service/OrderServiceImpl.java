package com.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.OrderMapper;
import com.demo.model.Order;
import com.demo.model.OrderDto;
import com.demo.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private  OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(Order order, List<OrderItem> items) {
        save(order);
        orderItemService.saveBatch(items);
        return true;
    }

    @Override
    public List<OrderDto> getOrderDetails(Integer orderId) {
        return orderMapper.getOrderDetails(orderId);
    }

}