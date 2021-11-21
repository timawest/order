package xyz.rbulatov.order.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import xyz.rbulatov.order.dto.ProductDTO;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Customer customer;
    private Timestamp datetime;
    @ManyToMany(mappedBy = "orderList",fetch = FetchType.EAGER)
    private List<Product> productList;
}
