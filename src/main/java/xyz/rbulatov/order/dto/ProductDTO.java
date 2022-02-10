package xyz.rbulatov.order.dto;

import lombok.Data;
import xyz.rbulatov.order.entity.Order;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private List<OrderDTO> orderList;
}
