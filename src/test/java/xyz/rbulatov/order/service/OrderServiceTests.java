package xyz.rbulatov.order.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.mapper.OrderMapper;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTests {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceTests(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Test
    @DisplayName("Тестирование вывода всех заказов")
    @Transactional
    public void testReadAll(){
        List<OrderDTO> list=orderMapper.toOrderDTOs(orderService.getAllOrder());
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @DisplayName("Тестирование вывода товаров по id")
    @Transactional
    public void testRead(){
        Optional<Order> order = orderService.getOrderById(1L);
        OrderDTO orderDTO = orderMapper.toOrderDTO(order.get());
        assertEquals("Ruslan", orderDTO.getCustomer().getName());
    }

}