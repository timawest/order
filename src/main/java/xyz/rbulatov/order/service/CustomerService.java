package xyz.rbulatov.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
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

    public Customer getCustomerByName(String name){ return customerRepository.findCustomerByName(name); }

    public void create(CustomerDTO customerDTO){ customerRepository.save(customerMapper.toCustomer(customerDTO)); }

    public void save(CustomerDTO customerDTO, Long id) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        customer.setId(id);
        customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
