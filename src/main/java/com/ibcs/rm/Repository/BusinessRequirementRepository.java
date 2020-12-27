package com.ibcs.rm.Repository;

import com.ibcs.rm.Entity.BusinessRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRequirementRepository extends JpaRepository<BusinessRequirement, Long> {
}
