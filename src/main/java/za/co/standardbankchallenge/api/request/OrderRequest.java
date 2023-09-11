package za.co.standardbankchallenge.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {


    private String isbn;
    @Min(value = 2, message = "quantity should not be less than 1")
    private double amount;
    @Min(value = 1, message = "quantity should not be less than 1")
    private int quantity;
}
