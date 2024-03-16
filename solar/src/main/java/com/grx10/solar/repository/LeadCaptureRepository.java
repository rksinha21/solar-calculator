package com.grx10.solar.repository;

import com.grx10.solar.model.LeadCapture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadCaptureRepository extends JpaRepository<LeadCapture, Long> {
}
