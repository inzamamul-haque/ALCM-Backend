package com.ibcs.rm.Repository;

import com.ibcs.rm.Entity.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonFunctionalRequirementRepository extends JpaRepository<NonFunctionalRequirement, Long> {
}
