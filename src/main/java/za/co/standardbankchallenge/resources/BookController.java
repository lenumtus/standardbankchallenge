package za.co.standardbankchallenge.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.standardbankchallenge.api.response.CustomResult;

import java.security.Principal;

@RequestMapping("api/book")
@RestController
@Slf4j
public class BookController extends BaseController{


    @GetMapping("all")
    public ResponseEntity<?> getAllTheBooks(Principal principal){

        log.info("===== lombok ===== {}",principal);
        return this.generateReturnResult(new CustomResult<>(principal.getName() , HttpStatus.OK, true));
    }
}
