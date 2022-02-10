package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Customer;
import xyz.rbulatov.order.entity.Order;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface OrderMapper {
    OrderDTO toOrderDTO(Order order);
    List<OrderDTO> toOrderDTOs(List<Order> orders);
    Order toOrder(OrderDTO orderDTO);
}
