package com.ibcs.rm.domain.repository;


import com.ibcs.rm.domain.model.ImageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDetailsRepository extends JpaRepository<ImageDetails, Long> {
}
