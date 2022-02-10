package xyz.rbulatov.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import xyz.rbulatov.order.dto.OrderDTO;
import xyz.rbulatov.order.entity.Order;

@Mapper
public interface OrderMapper {
    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    OrderDTO fromOrder(Order order);
}
