package xyz.rbulatov.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.mapper.CustomerMapper;
import xyz.rbulatov.order.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer : customerList){
            customerDTOList.add(CustomerMapper.CUSTOMER_MAPPER.fromCustomer(customer));
            System.out.println(customer.getName());
        }
        for (CustomerDTO customerDTO: customerDTOList){
            System.out.println(customerDTO.getName());
        }
        return customerDTOList;
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findCustomerById(id);
        CustomerDTO customerDTO = CustomerMapper.CUSTOMER_MAPPER.fromCustomer(customer);
        return customerDTO;
    }
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
