package xyz.rbulatov.order.dto;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private long id;
    private String name;
    private List<OrderDTO> orderList;
}
