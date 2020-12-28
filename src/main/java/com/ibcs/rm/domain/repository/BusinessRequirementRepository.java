package com.ibcs.rm.domain.repository;

import com.ibcs.rm.domain.model.BusinessRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRequirementRepository extends JpaRepository<BusinessRequirement, Long> {
}
