package xyz.rbulatov.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.mapper.OrderMapper;
import xyz.rbulatov.order.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository ordersRepository;
@Autowired
    public OrderService(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public List<OrderDTO> getAllOrder() {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        List<Order> orderList = ordersRepository.findAll();
        for (Order order : orderList){
            orderDTOList.add(OrderMapper.ORDER_MAPPER.fromOrder(order));
        }
        return orderDTOList;
    }
}

