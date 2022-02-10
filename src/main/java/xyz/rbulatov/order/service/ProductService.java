package xyz.rbulatov.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Product;
import xyz.rbulatov.order.mapper.ProductMapper;
import xyz.rbulatov.order.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product : productList){
            productDTOList.add(ProductMapper.PRODUCT_MAPPER.fromProduct(product));
        }
        return productDTOList;
    }
}
