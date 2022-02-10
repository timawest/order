package xyz.rbulatov.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.dto.ProductDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Product;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    public Customer create(CustomerDTO customerDTO){
        return customerRepository.save(customerMapper.toCustomer(customerDTO));
    }
    public Customer save(CustomerDTO customerDTO, Long id) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        customer.setId(id);
        return customerRepository.save(customer);
    }
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

}
