package za.co.standardbankchallenge.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.standardbankchallenge.api.response.CustomResult;
import za.co.standardbankchallenge.services.IBookService;

import java.security.Principal;

@RequestMapping("api/book")
@RestController
@Slf4j
public class BookController extends BaseController{
     @Autowired
    IBookService bookService;
    @GetMapping("all")
    public ResponseEntity<?> getAllTheBooks(){


        return this.generateReturnResult(new CustomResult<>(bookService.getAllBooks() , HttpStatus.OK, true));
    }
}
