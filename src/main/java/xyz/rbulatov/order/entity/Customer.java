package xyz.rbulatov.order.entity;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customer")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Orders> orders;
}
