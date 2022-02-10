package xyz.rbulatov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rbulatov.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
