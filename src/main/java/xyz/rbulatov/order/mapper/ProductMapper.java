package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Product;
import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProductDTOs(List<Product> products);
    Product toProduct(ProductDTO productDTO);
}
