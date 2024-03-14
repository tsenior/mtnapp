package ca.za.mtn.ContractRepaymentService.repository;

import ca.za.mtn.ContractRepaymentService.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity,Long> {
}
