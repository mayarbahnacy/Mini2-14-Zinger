package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p WHERE p.trip.id = :tripId")
    List<Payment> findByTripId(@Param("tripId") Long tripId);
    @Query("SELECT p FROM Payment p WHERE p.amount > :threshold")
    List<Payment> findByAmountGreaterThan(@Param("threshold") Double threshold);
}
