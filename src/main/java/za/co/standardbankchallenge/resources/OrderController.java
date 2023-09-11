package za.co.standardbankchallenge.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.standardbankchallenge.api.request.OrderRequest;
import za.co.standardbankchallenge.api.request.PageCriteria;
import za.co.standardbankchallenge.services.IOrderService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RequestMapping("api/order")
@RestController
@Slf4j
public class OrderController extends BaseController{

    @Autowired
    IOrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody @Valid OrderRequest orderRequest){

        return this.generateReturnResult(orderService.addOrder(orderRequest));

    }
    @GetMapping("/{size}/{page}")
    public ResponseEntity getAllOrders(@PathVariable("size") @NotBlank @Min(1) Integer size , @PathVariable("page") @NotBlank @NotBlank @Min(0) Integer page){

        PageCriteria pageCriteria = new PageCriteria(size , page);

    return this.generateReturnResult(orderService.getAllOrder(pageCriteria));
    }
}
