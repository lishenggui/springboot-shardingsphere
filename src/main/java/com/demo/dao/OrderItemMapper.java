package com.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {

}