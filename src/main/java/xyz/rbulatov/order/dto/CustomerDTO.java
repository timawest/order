package xyz.rbulatov.order.dto;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private List<OrderDTO> orderList;
}
