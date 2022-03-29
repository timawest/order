package xyz.rbulatov.order.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.mapper.OrderMapper;
import xyz.rbulatov.order.service.OrderService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
@Api("Контроллер по работе с заказами")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping
    @Operation(
            summary = "Отобразить все заказы",
            description = "Позволяет отобразить все заказы"
    )
    public ResponseEntity<List<OrderDTO>> findAllOrder() {
        return ResponseEntity.ok(orderMapper.toOrderDTOs(orderService.getAllOrder()));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск по ID",
            description = "Позволяет найти заказ по ID"
    )
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable @Parameter(description = "Идентификатор заказа") Long id) {
        return ResponseEntity.ok(orderMapper.toOrderDTO(orderService.getOrderById(id).get()));
    }

    @PutMapping("/put/{id}")
    @Operation(
            summary = "Изменить",
            description = "Позволяет изменить заказ"
    )
    public ResponseEntity<OrderDTO> update(@PathVariable @Parameter(description = "Идентификатор заказа") Long id, @RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Создать",
            description = "Позволяет зарегистрировать заказ"
    )
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO orderDTO) {
        orderService.create(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Удаление",
            description = "Позволяет удалить заказ по ID"
    )
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable @Parameter(description = "Идентификатор заказа") Long id) {
        orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
