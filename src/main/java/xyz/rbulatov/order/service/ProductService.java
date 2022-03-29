package xyz.rbulatov.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Product;
import xyz.rbulatov.order.mapper.ProductMapper;
import xyz.rbulatov.order.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<Product> getAllProduct() { return productRepository.findAll(); }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product getProductByName(String name){ return productRepository.findProductByName(name); }

    public Product create(ProductDTO productDTO){ return productRepository.save(productMapper.toProduct(productDTO)); }

    public Product save(ProductDTO productDTO, Long id) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
