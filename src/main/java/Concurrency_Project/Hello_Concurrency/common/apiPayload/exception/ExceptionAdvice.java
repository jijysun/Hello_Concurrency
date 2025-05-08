package Concurrency_Project.Hello_Concurrency.common.apiPayload.exception;


import Concurrency_Project.Hello_Concurrency.common.apiPayload.ApiResponse;
import Concurrency_Project.Hello_Concurrency.common.apiPayload.code.status.ErrorStatus;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice (annotations = RestController.class)
public class ExceptionAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> validation (ConstraintViolationException ex, WebRequest request) {
        String errorMessage = ex.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Constraint violation exception 추출 도중 에러 발생"));

        return handlerExceptionInteralConstrant(ex, ErrorStatus.valueOf(errorMessage), HttpHeaders.EMPTY, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    }

    private ResponseEntity<Object> handlerExceptionInteralConstrant(Exception ex, ErrorStatus errorStatus, HttpHeaders headers, WebRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorStatus.getCode(), errorStatus.getMessage(), null);
        return super.handleExceptionInternal(ex, body, headers, errorStatus.getHttpStatus(), request);
    }


}
