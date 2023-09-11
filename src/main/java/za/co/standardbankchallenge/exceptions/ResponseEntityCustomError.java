package za.co.standardbankchallenge.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import za.co.standardbankchallenge.api.response.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ResponseEntityCustomError extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {
        //Get all fields errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity<>(new CustomExceptionResponse(errors, false), headers, status);

    }



    @ExceptionHandler(ItemNotFoundException.class)
    public final ResponseEntity<CustomExceptionResponse> handleItemNotFoundException(Exception ex, WebRequest request) {

        List<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        CustomExceptionResponse errorDetails = new CustomExceptionResponse(errors, false);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<CustomExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

        List<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        CustomExceptionResponse errorDetails = new CustomExceptionResponse(errors, false);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
