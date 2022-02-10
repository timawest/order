package xyz.rbulatov.order.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Order;
import xyz.rbulatov.order.mapper.OrderMapper;
import xyz.rbulatov.order.service.OrderService;

import java.sql.Timestamp;


@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity findAllCustomer() {
        return ResponseEntity.ok(orderMapper.toOrderDTOs(orderService.getAllOrder()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderMapper.toOrderDTO(orderService.getOrderById(id).get()));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderDTO);
    }
    @PostMapping("/add")
    public ResponseEntity create(@RequestBody OrderDTO orderDTO) {
        orderService.create(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
