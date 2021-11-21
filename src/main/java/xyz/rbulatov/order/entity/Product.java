package xyz.rbulatov.order.entity;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import xyz.rbulatov.order.dto.OrderDTO;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int price;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orderList;
}
