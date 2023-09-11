package za.co.standardbankchallenge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import za.co.standardbankchallenge.api.response.OrderResponse;
import za.co.standardbankchallenge.entities.OrderEntity;

@Mapper(componentModel = "spring" , uses = {})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "id", target = "order_id")
    @Mapping(source = "bookEntity.isbn", target = "book_isbn")
    @Mapping(source = "bookEntity.title", target = "book_title")
    @Mapping(source = "bookEntity.author", target = "book_author")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "amount", target = "amount")
    @Mapping(source = "create_date", target = "create_date")
    OrderResponse orderToOrderResponse(OrderEntity order);

}
