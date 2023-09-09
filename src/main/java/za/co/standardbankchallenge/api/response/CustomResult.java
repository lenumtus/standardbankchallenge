package za.co.standardbankchallenge.api.response;

import org.springframework.http.HttpStatus;

public class CustomResult<T> {
    private T response;
    private HttpStatus status;
    private Boolean success;

    public CustomResult(T response, HttpStatus status, Boolean success) {
        super();
        this.response = response;
        this.status = status;
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


}
