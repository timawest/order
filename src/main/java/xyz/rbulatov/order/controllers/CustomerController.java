package xyz.rbulatov.order.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.service.CustomerService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
@Tag(name="Пользователи", description="Взаимодествие с пользователями")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping
    @ResponseBody
    public ResponseEntity findAllCustomer() {
        return ResponseEntity.ok(customerMapper.toCustomerDTOs(customerService.getAllCustomer()));
    }
    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id)
    {
        return ResponseEntity.ok(customerMapper.toCustomerDTO(customerService.getCustomerById(id).get()));
    }
    @PostMapping("/add")
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO) {
        customerService.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDTO);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
