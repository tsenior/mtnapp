package ca.za.mtn.ContractRepaymentService.service;

import ca.za.mtn.ContractRepaymentService.entity.DeviceEntity;
import ca.za.mtn.ContractRepaymentService.entity.RepaymentPeriodEntity;
import ca.za.mtn.ContractRepaymentService.exception.RepaymentCalculationException;
import ca.za.mtn.ContractRepaymentService.model.RepaymentDetailsResponse;
import ca.za.mtn.ContractRepaymentService.repository.DeviceRepository;
import ca.za.mtn.ContractRepaymentService.repository.RepaymentPeriodRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractRepaymentServiceImpl implements ContractRepaymentService{
    private final DeviceRepository deviceRepository;
    private final RepaymentPeriodRepository repaymentPeriodRepository;

    public ContractRepaymentServiceImpl(DeviceRepository deviceRepository, RepaymentPeriodRepository repaymentPeriodRepository) {
        this.deviceRepository = deviceRepository;
        this.repaymentPeriodRepository = repaymentPeriodRepository;
    }

    @Override
    public List<RepaymentDetailsResponse> calculateRepayments(double amount) {
        List<RepaymentDetailsResponse> repaymentDetailsList = new ArrayList<>();
        try {
        List<RepaymentPeriodEntity> repaymentPeriods = repaymentPeriodRepository.findAll();

            for (RepaymentPeriodEntity repaymentPeriod : repaymentPeriods) {
                double interestRate = repaymentPeriod.getInterestRate() / 100.0;
                int months = repaymentPeriod.getMonths();

                double totalRepaymentAmount = amount * Math.pow((1 + interestRate), (months / 12.0));

                double monthlyRepaymentAmount = totalRepaymentAmount / months;

                double totalInterestAmount = totalRepaymentAmount - amount;

                RepaymentDetailsResponse repaymentDetails = new RepaymentDetailsResponse(months, monthlyRepaymentAmount, totalRepaymentAmount, totalInterestAmount);
                repaymentDetailsList.add(repaymentDetails);
            }
        } catch (Exception e) {
            throw new RepaymentCalculationException("An error occurred while calculating repayments.", "REPAYMENTS_NOT_FOUND");
        }
        return repaymentDetailsList;
    }
}
