package xyz.rbulatov.order.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.service.CustomerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
@Slf4j
@Tag(name="Пользователи", description="Управление пользователями")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping
    @Operation(
            summary = "Отобразить всех пользователей",
            description = "Позволяет отобразить всех пользователей"
    )
    public ResponseEntity<List<CustomerDTO>> findAllCustomer() {
        return ResponseEntity.ok(customerMapper.toCustomerDTOs(customerService.getAllCustomer()));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск по ID",
            description = "Позволяет найти пользователя по ID"
    )
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable @Parameter(description = "Идентификатор пользователя") Long id) {
        return ResponseEntity.ok(customerMapper.toCustomerDTO(customerService.getCustomerById(id).get()));
    }

    @PostMapping("/add")
    @Operation(
            summary = "Создать",
            description = "Позволяет зарегистрировать пользователя"
    )
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
        customerService.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/put/{id}")
    @Operation(
            summary = "Изменить",
            description = "Позволяет изменить пользователя"
    )
    public ResponseEntity<CustomerDTO> update(@PathVariable @Parameter(description = "Идентификатор пользователя") Long id, @RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Удаление",
            description = "Позволяет удалить пользователя по ID"
    )
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable @Parameter(description = "Идентификатор пользователя") Long id) {
        customerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
