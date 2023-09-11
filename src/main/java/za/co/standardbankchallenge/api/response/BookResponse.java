package za.co.standardbankchallenge.api.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResponse {

    private String book_title;
    private String book_description;
    private String book_isbn;
    private String book_author;
    private String created_date;
    
}
