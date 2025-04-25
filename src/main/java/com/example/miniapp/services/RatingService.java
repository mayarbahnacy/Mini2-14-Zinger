package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating rating = optionalRating.get();
            rating.setScore(updatedRating.getScore());
            rating.setComment(updatedRating.getComment());
            rating.setRatingDate(updatedRating.getRatingDate());
            return ratingRepository.save(rating);
        }
        return null;
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }
}
