package ca.za.mtn.ContractRepaymentService.service;

import ca.za.mtn.ContractRepaymentService.model.RepaymentDetailsResponse;

import java.util.List;

public interface ContractRepaymentService {
    List<RepaymentDetailsResponse> calculateRepayments(double amount);
}
