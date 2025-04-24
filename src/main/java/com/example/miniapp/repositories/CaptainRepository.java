package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Captain;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {
    List<Captain> findByAvgRatingScoreGreaterThan(Double ratingThreshold);
    Captain findByLicenseNumber(String licenseNumber);
}
