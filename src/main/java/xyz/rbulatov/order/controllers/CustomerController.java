package xyz.rbulatov.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.service.CustomerService;

import java.util.List;
@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerDTO> findAllCustomer() {
        return customerService.getAllCustomer();
    }
    @GetMapping("/customers/{id}")
    @ResponseBody
    public CustomerDTO getCustomerId(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping("customers/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

}
