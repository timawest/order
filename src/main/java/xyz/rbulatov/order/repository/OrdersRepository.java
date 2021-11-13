package xyz.rbulatov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rbulatov.order.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
