package ca.za.mtn.ContractRepaymentService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract_repayment")
public class ContractRepaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repayment_id")
    private Long repaymentId;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    private DeviceEntity device;

    @ManyToOne
    @JoinColumn(name = "period_id", referencedColumnName = "period_id")
    private RepaymentPeriodEntity repaymentPeriod;

    @Column(name = "total_repayment_amount")
    private double totalRepaymentAmount;

    @Column(name = "monthly_repayment_amount")
    private double monthlyRepaymentAmount;

    @Column(name = "total_interest_amount")
    private double totalInterestAmount;

    @Column(name = "start_date")
    private Date startDate;
}
