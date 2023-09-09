package za.co.standardbankchallenge.resources;


import org.springframework.http.ResponseEntity;
import za.co.standardbankchallenge.api.response.CustomResult;


public class BaseController {


    protected ResponseEntity<?> generateReturnResult(CustomResult<?> commandResult) {


        return ResponseEntity.status(commandResult.getStatus()).body(commandResult.getResponse());
    }


}
