package xyz.rbulatov.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository ordersRepository;
    @Autowired
    public OrderService(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    public List<Order> getAllOrder()  {
        return ordersRepository.findAll();
    }
    public Optional<Order> getOrderById(Long id) {
        return ordersRepository.findById(id);
    }
    public Order save(Order order) {
        return ordersRepository.save(order);
    }
    public void deleteById(Long id) {
        ordersRepository.deleteById(id);
    }
}

