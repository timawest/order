package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Product;

@Mapper
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDTO fromProduct(Product product);
}
