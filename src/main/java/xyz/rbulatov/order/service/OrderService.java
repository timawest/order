package xyz.rbulatov.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.mapper.OrderMapper;
import xyz.rbulatov.order.repository.OrderRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository ordersRepository;
    private final OrderMapper orderMapper;
    public List<Order> getAllOrder()  {
        return ordersRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }
    public Order create (OrderDTO orderDTO){
        return  ordersRepository.save(orderMapper.toOrder(orderDTO));
    }
    public Order save(OrderDTO orderDTO, Long id) {
        Order order = orderMapper.toOrder(orderDTO);
        order.setId(id);
        order.setDatetime(new Timestamp(System.currentTimeMillis()));
        return ordersRepository.save(order);
    }
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}

