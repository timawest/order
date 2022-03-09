package xyz.rbulatov.order.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.mapper.ProductMapper;
import xyz.rbulatov.order.service.ProductService;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTests {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceTests(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Test
    @DisplayName("Тестирование создания продукта")
    @Transactional
    public void testCreate(){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName("TestName");
        productService.create(productDTO);
        assertNotNull(productService.getProductByName("TestName"));
        assertNull(productService.getProductByName("Test2Name"));
    }
    @Test
    @DisplayName("Тестирование вывода всех товаров")
    @Transactional
    public void testReadAll(){
        List<ProductDTO> list=productMapper.toProductDTOs(productService.getAllProduct());
        assertThat(list).size().isGreaterThan(0);
    }
    @Test
    @DisplayName("Тестирование вывода товаров по id")
    @Transactional
    public void testRead(){
        ProductDTO productDTO = productMapper.toProductDTO(productService.getProductById(1L).get());
        assertEquals("Apple", productDTO.getName());
    }
    @Test
    @DisplayName("Тестирование изменения товаров")
    @Transactional
    public void testUpDate(){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName("TestName");
        productService.create(productDTO);
        ProductDTO productDTO1 = productMapper.toProductDTO(productService.getProductByName("TestName"));
        productDTO.setName("TeStName2");
        productService.save(productDTO, productDTO1.getId());
        ProductDTO productDTO2 = productMapper.toProductDTO(productService.getProductByName("TeStName2"));
        assertEquals("TeStName2", productDTO2.getName());
    }
    @Test
    @DisplayName("Тестирование удаления товаров")
    @Transactional
    public void testDelete () {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName("TestName");
        productService.create(productDTO);
        ProductDTO productDTO1=productMapper.toProductDTO(productService.getProductByName("TestName"));
        productService.deleteById(productDTO1.getId());
        assertNull(productService.getProductByName("TestName"));
    }
}
