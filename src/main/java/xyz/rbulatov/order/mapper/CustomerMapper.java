package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface CustomerMapper {

    CustomerDTO toCustomerDTO(Customer customer);
    List<CustomerDTO> toCustomerDTOs(List<Customer> customers);
    Customer toCustomer(CustomerDTO customerDTO);
}
