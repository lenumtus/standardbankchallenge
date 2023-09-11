package za.co.standardbankchallenge.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.standardbankchallenge.repository.BookRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueIsbnValidationValidator implements ConstraintValidator<UniqueIsbnValidation, String> {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        return bookRepository.findByIsbn(s).isPresent();
    }
}
