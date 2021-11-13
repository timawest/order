package xyz.rbulatov.order.entity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Timestamp datetime;
    @ManyToMany
    @JoinTable(
            name = "order_to_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Products> products;
}
