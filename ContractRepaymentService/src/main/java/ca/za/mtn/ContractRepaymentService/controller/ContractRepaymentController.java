package ca.za.mtn.ContractRepaymentService.controller;

import ca.za.mtn.ContractRepaymentService.model.DeviceAmountRequest;
import ca.za.mtn.ContractRepaymentService.model.RepaymentDetailsResponse;
import ca.za.mtn.ContractRepaymentService.service.ContractRepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class ContractRepaymentController {


    private final ContractRepaymentService repaymentService;
    @Autowired

    public ContractRepaymentController(ContractRepaymentService repaymentService) {
        this.repaymentService = repaymentService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateRepayments(@RequestBody DeviceAmountRequest deviceAmountRequest) {
        // Validate input
        if (deviceAmountRequest.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("Device amount must be greater than zero.");
        }

        // Calculate repayments
        List<RepaymentDetailsResponse> repaymentDetails = repaymentService.calculateRepayments(deviceAmountRequest.getAmount());

        // Return calculated repayments
        return ResponseEntity.ok(repaymentDetails);
    }
}
