package xyz.rbulatov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.rbulatov.order.entity.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
}
