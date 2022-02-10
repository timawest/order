package xyz.rbulatov.order.dto;

import lombok.Data;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Data
public class OrderDTO {
    private Long id;
    private Customer customer;
    private Timestamp datetime;
    private List<ProductDTO> productList;
}
