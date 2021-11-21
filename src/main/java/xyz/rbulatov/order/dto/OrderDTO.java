package xyz.rbulatov.order.dto;

import lombok.Data;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Product;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Data
public class OrderDTO {
    private long id;
    private Customer customer;
    private Timestamp datetime;
    private List<ProductDTO> productDTOList;
}