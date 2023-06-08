package com.api.codetech.user.domain.service;

import com.api.codetech.user.domain.model.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();
    Review getById(Long reviewId);
    Review create(Review review, Long userId, Long technicalId);
    Review update(Long reviewId, Review review);
    Review delete(Long reviewId);
    List<Review> getByTechnicalIdAndOrderByScoreDesc(Long technicalId);
}
