package za.co.standardbankchallenge.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.standardbankchallenge.validations.UniqueIsbnValidation;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {


    @UniqueIsbnValidation(message = "ISBN does not exist please run list book api to get isbn")
    private String isbn;
    @DecimalMin(value = "1.0"  , message = "the amount must be a double and minimum of 1")
    private double amount;
    @Min(value = 1, message = "quantity should not be less than 1")
    private int quantity;
}
