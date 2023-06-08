package com.api.codetech.user.api;

import com.api.codetech.user.domain.service.ReviewService;
import com.api.codetech.user.mapping.ReviewMapper;
import com.api.codetech.user.resource.CreateReviewResource;
import com.api.codetech.user.resource.ReviewResource;
import com.api.codetech.user.resource.UpdateReviewResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reviews")
@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewMapper reviewMapper;

    @Operation(summary = "Get All Reviews", description = "Get All Reviews")
    @GetMapping
    public List<ReviewResource> getAll(){
        return reviewMapper.toResource(reviewService.getAll());
    }

    @Operation(summary = "Get Review by Id", description = "Get Review by Id")
    @GetMapping("{reviewId}")
    public ReviewResource getReviewById(@PathVariable Long reviewId){
        return reviewMapper.toResource(reviewService.getById(reviewId));
    }

    @Operation(summary = "Get Reviews by Technical Id order by Score", description = "Get Reviews by Technical Id order by Score")
    @GetMapping("/technical/{technicalId}")
    public List<ReviewResource> getReviewsByTechnicalIdOrderByScore(@PathVariable Long technicalId){
        return reviewMapper.toResource(reviewService.getByTechnicalIdAndOrderByScoreDesc(technicalId));
    }

    @Operation(summary = "Create New Review", description = "Create New Review")
    @PostMapping("user/{userId}/technical/{technicalId}")
    public ReviewResource createReview(@RequestBody CreateReviewResource model, @PathVariable Long userId, @PathVariable Long technicalId){
        return reviewMapper.toResource(reviewService.create(reviewMapper.toModel(model), userId, technicalId));
    }

    @Operation(summary = "Update Review", description = "Update Review")
    @PutMapping("{reviewId}")
    public ReviewResource updateReview(@PathVariable Long reviewId, @RequestBody UpdateReviewResource model){
        return reviewMapper.toResource(reviewService.update(reviewId, reviewMapper.toModel(model)));
    }

    @Operation(summary = "Delete Review", description = "Delete Review")
    @DeleteMapping("{reviewId}")
    public void deleteReview(@PathVariable Long reviewId){
        reviewService.delete(reviewId);
    }

}
