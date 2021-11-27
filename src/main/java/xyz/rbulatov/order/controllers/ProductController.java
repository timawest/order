package xyz.rbulatov.order.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Product;
import xyz.rbulatov.order.mapper.ProductMapper;
import xyz.rbulatov.order.service.ProductService;



@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> findAllProduct() {
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.getAllProduct()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductId(@PathVariable Long id) {
        return ResponseEntity.ok(productMapper.toProductDTO(productService.getProductById(id).get()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
        productService.save(productMapper.toProduct(productDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
