package com.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.UserMapper;
import com.demo.model.Order;
import com.demo.model.OrderDto;
import com.demo.model.OrderItem;
import com.demo.model.User;
import com.demo.service.OrderItemService;
import com.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingSpheredemoApplicationTests {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSaveOrder() {
        Order order1=new Order(1L,1L,new BigDecimal(22.5),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList1=new ArrayList<OrderItem>();
        orderItemList1.add(new OrderItem(1L,1L,"苹果",new BigDecimal(6),new BigDecimal(1),2));
        orderItemList1.add(new OrderItem(1L,2L,"香蕉",new BigDecimal(3.5),new BigDecimal(1),3));

        Order order2=new Order(2L,2L,new BigDecimal(799),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList2=new ArrayList<OrderItem>();
        orderItemList2.add(new OrderItem(2L,3L,"鞋子1",new BigDecimal(600),new BigDecimal(1),1));
        orderItemList2.add(new OrderItem(2L,4L,"衬衣1",new BigDecimal(199),new BigDecimal(1),1));

        Order order3=new Order(3L,2L,new BigDecimal(399),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList3=new ArrayList<OrderItem>();
        orderItemList3.add(new OrderItem(3L,5L,"鞋子2",new BigDecimal(200),new BigDecimal(1),1));
        orderItemList3.add(new OrderItem(3L,6L,"衬衣2",new BigDecimal(199),new BigDecimal(1),1));

        Order order4=new Order(4L,1L,new BigDecimal(499),new BigDecimal(1), new Date());
        List<OrderItem> orderItemList4=new ArrayList<OrderItem>();
        orderItemList4.add(new OrderItem(4L,7L,"鞋子3",new BigDecimal(300),new BigDecimal(1),1));
        orderItemList4.add(new OrderItem(4L,8L,"衬衣3",new BigDecimal(199),new BigDecimal(1),1));

        Order order5=new Order(5L,1L,new BigDecimal(899),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList5=new ArrayList<OrderItem>();
        orderItemList5.add(new OrderItem(5L,9L,"鞋子4",new BigDecimal(600),new BigDecimal(1),1));
        orderItemList5.add(new OrderItem(5L,10L,"衬衣4",new BigDecimal(299),new BigDecimal(1),1));

        Order order6=new Order(6L,2L,new BigDecimal(899),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList6=new ArrayList<OrderItem>();
        orderItemList6.add(new OrderItem(6L,9L,"鞋子6",new BigDecimal(600),new BigDecimal(1),1));
        orderItemList6.add(new OrderItem(6L,10L,"衬衣6",new BigDecimal(299),new BigDecimal(1),1));


        Order order7=new Order(7L,2L,new BigDecimal(899),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList7=new ArrayList<OrderItem>();
        orderItemList7.add(new OrderItem(7L,9L,"鞋子7",new BigDecimal(600),new BigDecimal(1),1));
        orderItemList7.add(new OrderItem(7L,10L,"衬衣7",new BigDecimal(299),new BigDecimal(1),1));

        Order order8=new Order(8L,1L,new BigDecimal(899),new BigDecimal(1),new Date());
        List<OrderItem> orderItemList8=new ArrayList<OrderItem>();
        orderItemList8.add(new OrderItem(8L,9L,"鞋子8",new BigDecimal(600),new BigDecimal(1),1));
        orderItemList8.add(new OrderItem(8L,10L,"衬衣8",new BigDecimal(299),new BigDecimal(1),1));
        assert (orderService.save(order1,orderItemList1));
        assert(orderService.save(order2,orderItemList2));
        assert(orderService.save(order3,orderItemList3));
        assert(orderService.save(order4,orderItemList4));
        assert(orderService.save(order5,orderItemList5));
        assert(orderService.save(order6,orderItemList6));
        assert(orderService.save(order7,orderItemList7));
        assert(orderService.save(order8,orderItemList8));
    }

    @Test
    public void testQuery(){
        Page page=new Page<OrderItem>(1,4);
        QueryWrapper queryWrapper=new QueryWrapper<OrderItem>();
        queryWrapper.orderByAsc("order_id");

        Page itemPage=orderItemService.page(page,queryWrapper);
        System.out.println(itemPage);
    }


    @Test
    public void testTwoTableQuery(){

        List<OrderDto>orderDtos = orderService.getOrderDetails(1);
        System.out.println(orderDtos);
    }

    @Test
    public void testBroardcastTableSave(){

        User user = new User(1L,"zhangsan",18);
        System.out.println(userMapper.insert(user));
    }
}
