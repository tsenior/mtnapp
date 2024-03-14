package ca.za.mtn.ContractRepaymentService.repository;

import ca.za.mtn.ContractRepaymentService.entity.ContractRepaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepaymentRepository extends JpaRepository<ContractRepaymentEntity, Long> {
}
