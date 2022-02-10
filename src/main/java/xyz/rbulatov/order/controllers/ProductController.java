package xyz.rbulatov.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    @ResponseBody
    public List<ProductDTO> findAllProduct() {
        System.out.println("productService.getAllProduct()");
        return productService.getAllProduct();
    }
}
