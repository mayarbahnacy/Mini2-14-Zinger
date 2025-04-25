package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Captain;

@Repository
public interface CaptainRepository extends JpaRepository<Captain, Long> {
    @Query ("SELECT c FROM Captain c WHERE c.avgRatingScore > :ratingThreshold")
    List<Captain> findByAvgRatingScoreGreaterThan(@Param("ratingThreshold") Double ratingThreshold);
    @Query ("SELECT c FROM Captain c WHERE c.licenseNumber = :licenseNumber")
    Captain findByLicenseNumber(@Param("licenseNumber") String licenseNumber);
}
