package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);
    List<Rating> findByScoreGreaterThan(int minScore);
}
