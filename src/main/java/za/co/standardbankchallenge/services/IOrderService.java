package za.co.standardbankchallenge.services;

import za.co.standardbankchallenge.api.request.OrderRequest;
import za.co.standardbankchallenge.api.request.PageCriteria;
import za.co.standardbankchallenge.api.response.CustomResult;

public interface IOrderService {

    public CustomResult<?> addOrder(OrderRequest request);


    public CustomResult<?> getAllOrder(PageCriteria criteria);
}
