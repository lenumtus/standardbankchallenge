package za.co.standardbankchallenge.exceptions;

import java.util.List;

public class CustomExceptionResponse {

    private List<String> errors;
    private Boolean succes;

    public CustomExceptionResponse() {

    }

    public CustomExceptionResponse(List<String> errors, Boolean succes) {
        super();
        this.errors = errors;
        this.succes = succes;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Boolean getSucces() {
        return succes;
    }

    public void setSucces(Boolean succes) {
        this.succes = succes;
    }


}
