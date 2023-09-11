package za.co.standardbankchallenge.api.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {

    private String order_id;
    private String book_isbn;
    private String book_title;
    private String book_author;
    private int quantity;
    private double amount;
    private String create_date;
}
