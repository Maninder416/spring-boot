package io.reactivestax.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    /**
     * In Previous version, we used to create Error class in which we provide all the details
     * to handle the exception but in java 17, they have provided the predefined class in
     * which we can set error message, code etc as according to our requirements.
     * In this example, I am only providing error code and error message but you can also
     * use set method to define more parameters.
     * detail.set
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail problemDetail(RuntimeException exception) {
        ProblemDetail detail = ProblemDetail.forStatusAndDetail(
                HttpStatus.valueOf(400), exception.getMessage());
        return detail;

    }
}
