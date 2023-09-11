package za.co.standardbankchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.standardbankchallenge.api.response.BookResponse;
import za.co.standardbankchallenge.api.response.ItemNotFoundException;
import za.co.standardbankchallenge.entities.BookEntity;
import za.co.standardbankchallenge.mappers.BookMapper;
import za.co.standardbankchallenge.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookResponse> getAllBooks() {

        return bookRepository.findAll().stream()
                .map(book -> BookMapper.INSTANCE.bookTobookResponse(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookEntity findBookByIsbn(String isbn) {

        BookEntity bookEntity = bookRepository.findByIsbn(isbn).orElseThrow(()-> new ItemNotFoundException("Book with isbn does not exist please get isbn from book api"));
        return bookEntity;
    }
}
