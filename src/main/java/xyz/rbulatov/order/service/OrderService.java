package xyz.rbulatov.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.mapper.OrderMapper;
import xyz.rbulatov.order.repository.OrderRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository ordersRepository;
    private final OrderMapper orderMapper;

    public List<Order> getAllOrder()  {
        return ordersRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) { return ordersRepository.findById(id); }

    public void create (OrderDTO orderDTO){ ordersRepository.save(orderMapper.toOrder(orderDTO)); }

    public void save(OrderDTO orderDTO, Long id) {
        Order order = orderMapper.toOrder(orderDTO);
        order.setId(id);
        order.setDatetime(new Timestamp(System.currentTimeMillis()));
        ordersRepository.save(order);
    }
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}