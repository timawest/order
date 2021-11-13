package xyz.rbulatov.order.entity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private int price;
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;
}
