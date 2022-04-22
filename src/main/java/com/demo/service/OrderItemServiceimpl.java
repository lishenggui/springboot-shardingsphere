package com.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.OrderItemMapper;
import com.demo.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceimpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}