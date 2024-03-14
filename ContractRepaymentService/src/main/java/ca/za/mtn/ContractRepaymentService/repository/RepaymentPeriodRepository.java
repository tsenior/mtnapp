package ca.za.mtn.ContractRepaymentService.repository;

import ca.za.mtn.ContractRepaymentService.entity.RepaymentPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepaymentPeriodRepository extends JpaRepository<RepaymentPeriodEntity, Long> {
}
