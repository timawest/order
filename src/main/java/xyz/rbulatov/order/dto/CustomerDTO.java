package xyz.rbulatov.order.dto;

import lombok.Data;
import xyz.rbulatov.order.entity.Order;

import java.util.List;

@Data
public class CustomerDTO {

    private Long id;
    private String name;
    private List<Order> orderList;
}
