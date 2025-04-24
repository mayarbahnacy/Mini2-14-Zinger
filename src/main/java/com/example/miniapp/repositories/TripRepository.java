package com.example.miniapp.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByTripDateBetween(LocalDateTime start, LocalDateTime end);
    List<Trip> findByCaptainId(Long captainId);
}
