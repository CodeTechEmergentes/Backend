package com.api.codetech.user.domain.persistence;

import com.api.codetech.user.domain.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long userId);
    List<Review> findByTechnicalId(Long technicalId);
    List<Review> findByTechnicalIdOrderByScoreDesc(Long technicalId);
}
