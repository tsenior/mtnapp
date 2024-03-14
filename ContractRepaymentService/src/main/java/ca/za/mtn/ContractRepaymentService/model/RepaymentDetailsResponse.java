package ca.za.mtn.ContractRepaymentService.model;

import ca.za.mtn.ContractRepaymentService.entity.DeviceEntity;
import ca.za.mtn.ContractRepaymentService.entity.RepaymentPeriodEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepaymentDetailsResponse {
    private int period;
    private double monthlyRepaymentAmount;
    private double totalRepaymentAmount;
    private double totalInterestAmount;
}
