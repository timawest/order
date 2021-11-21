package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.rbulatov.order.dto.CustomerDTO;
import xyz.rbulatov.order.entity.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO fromCustomer(Customer customer);
}
