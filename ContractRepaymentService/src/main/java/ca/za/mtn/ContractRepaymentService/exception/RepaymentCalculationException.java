package ca.za.mtn.ContractRepaymentService.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class RepaymentCalculationException extends RuntimeException {
    public String errorCode;
    public RepaymentCalculationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
