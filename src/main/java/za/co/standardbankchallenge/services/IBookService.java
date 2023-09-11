package za.co.standardbankchallenge.services;

import za.co.standardbankchallenge.api.response.BookResponse;
import za.co.standardbankchallenge.entities.BookEntity;

import java.util.List;

public interface IBookService {

    public List<BookResponse> getAllBooks();

    public BookEntity findBookByIsbn(String isbn);
}
