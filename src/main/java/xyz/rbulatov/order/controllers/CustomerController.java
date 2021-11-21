package xyz.rbulatov.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
