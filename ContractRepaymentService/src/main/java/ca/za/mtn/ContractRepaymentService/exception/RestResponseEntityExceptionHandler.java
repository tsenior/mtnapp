package ca.za.mtn.ContractRepaymentService.exception;

import ca.za.mtn.ContractRepaymentService.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RepaymentCalculationException.class)
    public ResponseEntity<CustomErrorResponse> handleContractRepaymentServiceException(RepaymentCalculationException exception){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
