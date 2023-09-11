package za.co.standardbankchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import za.co.standardbankchallenge.api.request.OrderRequest;
import za.co.standardbankchallenge.api.request.PageCriteria;
import za.co.standardbankchallenge.api.response.CustomResult;
import za.co.standardbankchallenge.api.response.OrderResponse;
import za.co.standardbankchallenge.api.response.PageResponse;
import za.co.standardbankchallenge.entities.BookEntity;
import za.co.standardbankchallenge.entities.OrderEntity;
import za.co.standardbankchallenge.mappers.OrderMapper;
import za.co.standardbankchallenge.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IOrderServiceImpl implements IOrderService{
    @Autowired
    private OrderRepository repository;
    @Autowired
    private IBookService bookService;


    @Override
    public CustomResult<?> addOrder(OrderRequest request) {
        BookEntity bookEntity = bookService.findBookByIsbn(request.getIsbn());
        OrderEntity order = new OrderEntity();
        order.setAmount(request.getAmount());
        order.setQuantity(request.getQuantity());
        order.setBookEntity(bookEntity);
        order.setStatus("active");
        OrderEntity newOrderEntity = repository.save(order);
        return new CustomResult<>(OrderMapper.INSTANCE.orderToOrderResponse(newOrderEntity) , HttpStatus.OK , true);
    }

    @Override
    public CustomResult<?> getAllOrder(PageCriteria criteria) {

        PageRequest pageRequest = PageRequest.of(criteria.getPage(), criteria.getSize());
        Page<OrderEntity> page = repository.findAll(pageRequest);
        List<OrderResponse> orderResponses = page.getContent()
                .stream().map(OrderMapper.INSTANCE::orderToOrderResponse)
                .collect(Collectors.toList());
        PageResponse<OrderResponse> pageResponse = new PageResponse();
        pageResponse.setTotalPage(page.getTotalPages());
        pageResponse.setCurrentpage(page.getNumber());
        pageResponse.setItems(orderResponses);
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setSize(page.getSize());


        return new CustomResult<>(pageResponse , HttpStatus.OK , true);
    }
}
