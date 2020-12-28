package com.ibcs.rm.domain.repository;

import com.ibcs.rm.domain.model.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonFunctionalRequirementRepository extends JpaRepository<NonFunctionalRequirement, Long> {
}
