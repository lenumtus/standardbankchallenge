package za.co.standardbankchallenge.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {


    private String isbn;
    private double amount;
    private int quantity;
}
