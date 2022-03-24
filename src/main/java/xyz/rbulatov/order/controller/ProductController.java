package xyz.rbulatov.order.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.mapper.ProductMapper;
import xyz.rbulatov.order.service.ProductService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
@Api("Контроллер по работе с продуктами")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    @Operation(
            summary = "Отобразить все товары",
            description = "Позволяет отобразить все товары"
    )
    public ResponseEntity<List<ProductDTO>> findAllProduct() {
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.getAllProduct()));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск по ID",
            description = "Позволяет найти товар по ID"
    )
    public ResponseEntity<ProductDTO> getProductById(@PathVariable @Parameter(description = "Идентификатор товара") Long id) {
        return ResponseEntity.ok(productMapper.toProductDTO(productService.getProductById(id).get()));
    }

    @PostMapping("/add")
    @Operation(
            summary = "Создать",
            description = "Позволяет зарегистрировать товар"
    )
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        productService.create(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/put/{id}")
    @Operation(
            summary = "Изменить",
            description = "Позволяет изменить товар"
    )

    public ResponseEntity<ProductDTO> update(@PathVariable @Parameter(description = "Идентификатор товара") Long id, @RequestBody ProductDTO productDTO) {
        productService.save(productDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Удаление",
            description = "Позволяет удалить товар по ID"
    )
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable @Parameter(description = "Идентификатор товара") Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}