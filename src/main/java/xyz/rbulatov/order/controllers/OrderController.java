package xyz.rbulatov.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.service.OrderService;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }


    @GetMapping("/orders")
    @ResponseBody
    public List<OrderDTO> findAllOrder() {
        System.out.println("orderService.getAllOrder()");
        return orderService.getAllOrder();
    }

}
