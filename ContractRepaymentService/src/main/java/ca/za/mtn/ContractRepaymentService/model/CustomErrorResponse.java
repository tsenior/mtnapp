package ca.za.mtn.ContractRepaymentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {
    private String errorMessage;
    private String errorCode;

}
