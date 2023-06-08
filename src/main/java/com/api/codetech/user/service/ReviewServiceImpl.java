package com.api.codetech.user.service;

import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.technical.domain.model.entity.Technical;
import com.api.codetech.technical.domain.persistence.TechnicalRepository;
import com.api.codetech.user.domain.model.entity.Review;
import com.api.codetech.user.domain.model.entity.User;
import com.api.codetech.user.domain.persistence.ReviewRepository;
import com.api.codetech.user.domain.persistence.UserRepository;
import com.api.codetech.user.domain.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final static String ENTITY = "Review";
    private final static String ENTITY2 = "User";
    private final static String ENTITY3 = "Technical";

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechnicalRepository technicalRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepository.getById(reviewId);
    }

    @Override
    public Review create(Review review, Long userId, Long technicalId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(ENTITY2, userId));
        Technical technical = technicalRepository.findById(technicalId).orElseThrow(() -> new ResourceNotFoundException(ENTITY3, technicalId));

        review.setUser(user);
        review.setTechnical(technical);

        return reviewRepository.save(review);
    }

    @Override
    public Review update(Long reviewId, Review request) {
        return reviewRepository.findById(reviewId)
                .map(r -> reviewRepository.save(
                        r.withText(request.getText())
                                .withScore(request.getScore())
                                .withMagnitude(request.getMagnitude())
                )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reviewId));
    }

    @Override
    public Review delete(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .map(r -> {
                    reviewRepository.delete(r);
                    return r;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reviewId));
    }

    @Override
    public List<Review> getByTechnicalIdAndOrderByScoreDesc(Long technicalId) {
        return reviewRepository.findByTechnicalIdOrderByScoreDesc(technicalId);
    }
}

